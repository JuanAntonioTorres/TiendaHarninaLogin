package controller;



import validate.ValidacionCadenaSinEspacio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vali")
public class ValidarClientInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String clientFirstName = request.getParameter("clientFirstName");
        ValidacionCadenaSinEspacio validacionCadenaSinEspacio = new ValidacionCadenaSinEspacio(clientFirstName);
           System.out.println(validacionCadenaSinEspacio.validar(validacionCadenaSinEspacio.getPatron(),validacionCadenaSinEspacio.getValue()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
