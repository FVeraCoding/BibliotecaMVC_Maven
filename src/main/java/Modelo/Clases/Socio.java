
package Modelo.Clases;

import java.util.Date;


public class Socio {
    int id;
    String nombre;
    String apellidos;
    Date fecha_nacimiento;
    String correo_electronico;
    String telefono;
    String direccion;
    Date fecha_alta;
    int id_usuario;
    int id_club;

    
    
    public Socio(String nombre, String apellidos, Date fecha_nacimiento, String correo_electronico, String telefono, String direccion, int id_usuario, int id_club) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_usuario = id_usuario;
        this.id_club = id_club;
    }

    public Socio(int id, String nombre, String apellidos, Date fecha_nacimiento, String correo_electronico, String telefono, String direccion, Date fecha_alta, int id_usuario, int id_club) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_alta = fecha_alta;
        this.id_usuario = id_usuario;
        this.id_club = id_club;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    @Override
    public String toString() {
        return "Socio: " + "id: " + id + "| nombre: " + nombre + "| apellidos: " + apellidos + "| fecha_nacimiento: " + fecha_nacimiento + "| correo_electronico: " + correo_electronico + "| telefono: " + telefono + "| direccion: " + direccion + "| fecha_alta: " + fecha_alta + "| id_usuario: " + id_usuario + "| id_club: " + id_club;
    }
    
    
    
    
}
