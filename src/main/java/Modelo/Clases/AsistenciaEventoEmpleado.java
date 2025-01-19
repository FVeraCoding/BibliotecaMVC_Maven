
package Modelo.Clases;


public class AsistenciaEventoEmpleado {
    int idEvento;
    int idEmpleado;

    public AsistenciaEventoEmpleado(int idEvento, int idEmpleado) {
        this.idEvento = idEvento;
        this.idEmpleado = idEmpleado;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}
