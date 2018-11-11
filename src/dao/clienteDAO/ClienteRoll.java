package dao.clienteDAO;

import dao.AccesoDB;
import entity.ClientEntity;

import java.lang.reflect.Field;
import java.sql.*;

public class ClienteRoll {

    private AccesoDB acceso = null;

    private void conectar() {
        acceso = AccesoDB.getMiConexion();
        try {
            acceso.conectar("com.mysql.cj.jdbc.Driver", //com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost/tienda_harnina20189vistas?useInformationSchema=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //Un objeto ResultSet mantiene un cursor que apunta a su fila actual de datos. Inicialmente el cursor se coloca antes de la primera fila.
    public ResultSet getCursor(String sql) throws SQLException {
        this.conectar();
        ResultSet cursor = acceso.executeQuery(sql);
        return cursor;
    }

    public int insertUpdateDelete(String sql) throws SQLException {
        this.conectar();
        return acceso.executeUpdate(sql);
    }

    // Uso de procedures

    public boolean comprobarLogin(String usuario,String password) throws SQLException, NoSuchFieldException {
        this.conectar();
        CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call comprobarLogin(?, ?, ?)}");
        cstmt.setString(1,usuario);
        cstmt.setString(2,password);
        cstmt.registerOutParameter(3, Types.BOOLEAN);
        cstmt.execute();
        return  cstmt.getBoolean(3);
    }

    public boolean add_cliente(ClientEntity cliente) throws SQLException, NoSuchFieldException {
        this.conectar();
        CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call add_cliente(?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        cstmt.setString(1,cliente.getNifCliente());
        cstmt.setString(2,cliente.getApellidosCliente());
        cstmt.setString(3,cliente.getNombreCliente());
        cstmt.setString(4,cliente.getCodigoPostalClient());
        cstmt.setString(5,cliente.getDomicilioCliente());
        cstmt.setString(6,cliente.getFechaNacimiento());
        cstmt.setString(7,cliente.getTelefonoCliente());
        cstmt.setString(8,cliente.getMovilCliente());
        cstmt.setString(9,cliente.getSexoCliente());
        cstmt.setString(10,cliente.getEmailCliente());
        cstmt.setString(11,cliente.getImagenCliente());
        cstmt.setString(12,cliente.getUsuarioCliente());
        cstmt.setString(13,cliente.getPasswordCliente());
        cstmt.registerOutParameter(14, Types.BOOLEAN);
        cstmt.execute();
        return  cstmt.getBoolean(14);
    }

}
