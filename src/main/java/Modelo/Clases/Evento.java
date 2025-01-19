
package Modelo.Clases;

import java.time.LocalDateTime;


public class Evento {
    int id;
    String nombre;
    String descripcion;
    LocalDateTime fecha;
    int idEmpleadoOrganizador;
    int idSucursal;

    public Evento(String nombre, String descripcion, LocalDateTime fecha, int idEmpleadoOrganizador, int idSucursal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idEmpleadoOrganizador = idEmpleadoOrganizador;
        this.idSucursal = idSucursal;
    }

    public Evento(int id, String nombre, String descripcion, LocalDateTime fecha, int idEmpleadoOrganizador, int idSucursal) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idEmpleadoOrganizador = idEmpleadoOrganizador;
        this.idSucursal = idSucursal;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    public int getIdEmpleadoOrganizador() {
        return idEmpleadoOrganizador;
    }

    public void setIdEmpleadoOrganizador(int idEmpleadoOrganizador) {
        this.idEmpleadoOrganizador = idEmpleadoOrganizador;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha +  ", idEmpleadoOrganizador=" + idEmpleadoOrganizador + ", idSucursal=" + idSucursal + '}';
    }    
    
}
