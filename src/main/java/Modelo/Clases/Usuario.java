
package Modelo.Clases;


public class Usuario {
    private int id;
    private String nombreUsuario;
    private String password;
    private String rol;

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }
    
    

    public Usuario(int id, String nombreUsuario, String password, String rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }
    
    public Usuario(String nombreUsuario, String password, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "ID: "+this.id+" | Nombre: "+this.nombreUsuario+" | Password: "+this.password+" | Rol: "+this.rol;
    }
    
    
    
    
}
