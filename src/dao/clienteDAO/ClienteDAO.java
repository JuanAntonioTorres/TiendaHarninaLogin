package dao.clienteDAO;

import entity.ClientEntity;
import java.lang.reflect.Field;
import java.sql.SQLException;

public class ClienteDAO {

    ClienteRoll clienteRoll = new ClienteRoll();


   public boolean add_cliente_procedure(ClientEntity cliente) throws NoSuchFieldException, SQLException {
        return clienteRoll.add_cliente(cliente);
   }

    public boolean add_cliente(ClientEntity cliente) throws IllegalAccessException, SQLException {

        StringBuilder senteniaSQL = new StringBuilder();

        senteniaSQL.append("INSERT INTO `cliente`(");

        Field[] camposCliente = cliente.getClass().getDeclaredFields();

        formarParteUnoDeInsertClient(senteniaSQL, camposCliente);

        formarParteDosDeInsertCliente(senteniaSQL, camposCliente);

        System.out.println(senteniaSQL);

        return clienteRoll.insertUpdateDelete(new String(senteniaSQL)) > 0;

    }

    private void formarParteDosDeInsertCliente(StringBuilder senteniaSQL, Field[] camposCliente) throws IllegalAccessException {
        for (int i = 0; i < camposCliente.length; i++) {
            System.out.println(String.valueOf(senteniaSQL));
            senteniaSQL.append(camposCliente[i].get(camposCliente[i].getName()));
            if (i < camposCliente.length - 1) {
                senteniaSQL.append(",");
            } else {
                senteniaSQL.append(")");
            }
        }
    }

    private void formarParteUnoDeInsertClient(StringBuilder senteniaSQL, Field[] camposCliente) {
        for (int i = 0; i < camposCliente.length; i++) {
            senteniaSQL.append(" '" + camposCliente[i].getName() + "' ");
            if(i< camposCliente.length-1){
                senteniaSQL.append(",");
            }
            else{
                senteniaSQL.append(") VALUES (");
            }
        }
        System.out.println(String.valueOf(senteniaSQL));
    }

    public boolean validarLogin(String usuario, String password) throws NoSuchFieldException, SQLException {
       return clienteRoll.comprobarLogin(usuario,password);
    }
}
