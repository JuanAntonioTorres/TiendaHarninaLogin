package controller;

import dao.clienteDAO.ClienteDAO;
import entity.ClientEntity;
import validate.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/valiCliIn")
@MultipartConfig
public class ValidarClientInsertController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    HttpSession session;
    ClientEntity cliente;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

        cliente = new ClientEntity();

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        String error = "";

        List<IValidacion> validador = new ArrayList<IValidacion>();

        RequestDispatcher rd = request.getRequestDispatcher("clientInsert.jsp");

        new GuardadorDeDatosEnSession().guardarDatosSesion(request,session);

        try {
            new GeneradorDeObjetoConSession().generarObjeto(session,cliente);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        validador.add(new ValidacionDNINIECIF(cliente.getNifCliente()));
        validador.add(new ValidacionLetrasConEspacio(cliente.getNombreCliente()));
        validador.add(new ValidacionLongitud(cliente.getNombreCliente(),3,50));
        validador.add(new ValidacionLetrasConEspacio(cliente.getApellidosCliente()));
        validador.add(new ValidacionLongitud(cliente.getApellidosCliente(),3,100));
        validador.add(new ValidacionCodigoPostal(cliente.getCodigoPostalClient()));
        validador.add(new ValidarDomicilio(cliente.getDomicilioCliente()));
        validador.add(new ValidacionLongitud(cliente.getDomicilioCliente(),2,100));
        validador.add(new ValidacionTelefonoSpain(cliente.getTelefonoCliente()));
        validador.add(new ValidacionTelefonoSpain(cliente.getMovilCliente()));
        validador.add(new ValidacionFecha(cliente.getFechaNacimiento()));
        validador.add(new ValidacionSexo(cliente.getSexoCliente()));
        validador.add(new ValidacionEmail(cliente.getEmailCliente()));
        validador.add(new ValidacionUsuario(cliente.getUsuarioCliente()));
        validador.add(new ValidacionPassword(cliente.getPasswordCliente()));

        for (int i = 0; i < validador.size(); i++) {
            if(!validador.get(i).validar()){
                error += validador.get(i).getError();
            }
        }


        if (error.length() > 0){
            request.setAttribute("error", error);
        }else {
            request.setAttribute("error", "Todo Correcto");
            clientFotoLoad(request,response);
            cliente.setImagenCliente(cliente.getNifCliente() + ".png");
            System.out.println(cliente.toString());
            rd = request.getRequestDispatcher("index.jsp");
            //    cliente para BD
            ClienteDAO clienteDAO = new ClienteDAO();
            try {
                clienteDAO.add_cliente_procedure(cliente);
                request.setAttribute("mensaje", "Cliente add");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return "fotoSin.jpg";
    }

    private void clientFotoLoad(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {

        Part filePart = request.getPart("ImagenCliente");
        String fileName = getFileName(filePart);
        String dniCliente = request.getParameter("NifCliente");

        if (fileName.length() > 2) {

            fileName = dniCliente + ".png";

            String path = getServletContext().getRealPath("img/fotoClient/");

            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            FileOutputStream fs = new FileOutputStream(new File(path + fileName));
            BufferedOutputStream buf = new BufferedOutputStream(fs);

            InputStream fileContent = filePart.getInputStream();
            BufferedInputStream bufIN = new BufferedInputStream(fileContent);

            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = bufIN.read(buffer)) != -1) {
                buf.write(buffer, 0, bytesRead);
            }

            buf.close();
            bufIN.close();
        }
    }

}

