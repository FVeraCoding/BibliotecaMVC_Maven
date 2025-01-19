
package Modelo.Clases;


public class Ejemplar {
    int id;
    String estado;
    int id_sucursal;
    int id_libro;

    public Ejemplar(String estado, int id_sucursal, int id_libro) {
        this.estado = estado;
        this.id_sucursal = id_sucursal;
        this.id_libro = id_libro;
    }

    
    
    public Ejemplar(int id, String estado, int id_sucursal, int id_libro) {
        this.id = id;
        this.estado = estado;
        this.id_sucursal = id_sucursal;
        this.id_libro = id_libro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "id=" + id + ", estado=" + estado + ", id_sucursal=" + id_sucursal + ", id_libro=" + id_libro + '}';
    }
    
    
    
    
    
    
}


