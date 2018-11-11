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

@WebServlet("/valiLoginIn")
@MultipartConfig
public class ValidarClientLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HttpSession session;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        String error = "";

        RequestDispatcher rd = request.getRequestDispatcher("clientLogin.jsp");

        new GuardadorDeDatosEnSession().guardarDatosSesion(request,session);

        String usuario = request.getParameter("UsuarioCliente");
        String password = request.getParameter("PasswordCliente");

        try {
            if (!new ClienteDAO().validarLogin(usuario,password)){
                request.setAttribute("error", "ususario o contraseña no valido");
            }else {
                rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("mensaje", "Bienvenido " + usuario);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}

