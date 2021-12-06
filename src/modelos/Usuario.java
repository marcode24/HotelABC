package modelos;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String cargo;
    private String direccion;
    private int telefono;
    private String usuario;
    private String password;
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public String getCargo() {
        return this.cargo;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public int getTelefono() {
        return this.telefono;
    }
    public String getUsuario() {
        return this.usuario;
    }
    public String getPassword() {
        return this.password;
    }
}
