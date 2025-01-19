
package Modelo.Clases;


public class AsistenciaEventoSocio {
    int idEvento;
    int idSocio;

    public AsistenciaEventoSocio(int idEvento, int idSocio) {
        this.idEvento = idEvento;
        this.idSocio = idSocio;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    
    
}
