package prueba;

import dao.clienteDAO.ClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoDB {

    public static void main(String [] args) throws SQLException, ClassNotFoundException, NoSuchFieldException {
        System.out.println(new ClienteDAO().validarLogin("jrt1234","asdASD123"));
    }
}
