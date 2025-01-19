
package Modelo.Clases;

import java.util.Date;


public class Club {
    int id;
    String nombre;
    String descripcion;
    Date fechaCreacion;
    int idEmpleadoGestor;

    public Club(int id, String nombre, String descripcion, Date fechaCreacion, int idEmpleadoGestor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.idEmpleadoGestor = idEmpleadoGestor;
    }

    public Club(String nombre, String descripcion, Date fechaCreacion, int idEmpleadoGestor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.idEmpleadoGestor = idEmpleadoGestor;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdEmpleadoGestor() {
        return idEmpleadoGestor;
    }

    public void setIdEmpleadoGestor(int idEmpleadoGestor) {
        this.idEmpleadoGestor = idEmpleadoGestor;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + ", idEmpleadoGestor=" + idEmpleadoGestor + '}';
    }
    
    
}
