package entity;

public class ClientEntity {

    public String NifCliente; // varchar(9)
    public String ApellidosCliente; // varchar(100)
    public String NombreCliente; // varchar(50)
    public String CodigoPostalClient; // varchar(5)
    public String DomicilioCliente; // varchar(100)
    public String FechaNacimiento; // date
    public String TelefonoCliente;
    public String MovilCliente;
    public String SexoCliente; //char(1)
    public String EmailCliente; // varchar(150)
    public String ImagenCliente; // varchar(15)
    public String UsuarioCliente; // varchar(7)
    public String PasswordCliente; // varchar(50)

    public ClientEntity() {

    }

    public String getNifCliente() {
        return NifCliente;
    }

    public void setNifCliente(String nifCliente) {
        NifCliente = nifCliente;
    }

    public String getApellidosCliente() {
        return ApellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        ApellidosCliente = apellidosCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getCodigoPostalClient() {
        return CodigoPostalClient;
    }

    public void setCodigoPostalClient(String codigoPostalClient) {
        CodigoPostalClient = codigoPostalClient;
    }

    public String getDomicilioCliente() {
        return DomicilioCliente;
    }

    public void setDomicilioCliente(String domicilioCliente) {
        DomicilioCliente = domicilioCliente;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        TelefonoCliente = telefonoCliente;
    }

    public String getMovilCliente() {
        return MovilCliente;
    }

    public void setMovilCliente(String movilCliente) {
        MovilCliente = movilCliente;
    }

    public String getSexoCliente() {
        return SexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        SexoCliente = sexoCliente;
    }

    public String getEmailCliente() {
        return EmailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        EmailCliente = emailCliente;
    }

    public String getImagenCliente() {
        return ImagenCliente;
    }

    public void setImagenCliente(String imagenCliente) {
        ImagenCliente = imagenCliente;
    }

    public String getUsuarioCliente() {
        return UsuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        UsuarioCliente = usuarioCliente;
    }

    public String getPasswordCliente() {
        return PasswordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        PasswordCliente = passwordCliente;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "NifCliente='" + NifCliente + '\'' +
                ", ApellidosCliente='" + ApellidosCliente + '\'' +
                ", NombreCliente='" + NombreCliente + '\'' +
                ", CodigoPostalClient='" + CodigoPostalClient + '\'' +
                ", DomicilioCliente='" + DomicilioCliente + '\'' +
                ", FechaNacimiento='" + FechaNacimiento + '\'' +
                ", TelefonoCliente='" + TelefonoCliente + '\'' +
                ", MovilCliente='" + MovilCliente + '\'' +
                ", SexoCliente='" + SexoCliente + '\'' +
                ", EmailCliente='" + EmailCliente + '\'' +
                ", ImagenCliente='" + ImagenCliente + '\'' +
                ", UsuarioCliente='" + UsuarioCliente + '\'' +
                ", PasswordCliente='" + PasswordCliente + '\'' +
                '}';
    }
}
