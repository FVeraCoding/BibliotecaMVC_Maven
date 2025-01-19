
package Modelo.Clases;

import java.sql.*;

public class Sucursal {
    int id;
    String nombre;
    String direccion;
    String telefono;
    Time horaApertura;
    Time horaCierre;
    int capacidad;

    public Sucursal(String nombre, String direccion, String telefono, Time horaApertura, Time horaCierre, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.capacidad = capacidad;
    }
    
    public Sucursal(int id, String nombre, String direccion, String telefono, Time horaApertura, Time horaCierre, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.capacidad = capacidad;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Time getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Time horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Time getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Time horaCierre) {
        this.horaCierre = horaCierre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", capacidad=" + capacidad + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}


