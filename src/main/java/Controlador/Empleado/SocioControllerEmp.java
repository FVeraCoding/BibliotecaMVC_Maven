package Controlador.Empleado;

import Modelo.Clases.Libro;
import Modelo.Clases.Socio;
import Modelo.ClasesDAO.SocioDAO;
import Vista.Empleado.SociosVistaEmp;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SocioControllerEmp {

    SociosVistaEmp vistaSocios;
    SocioDAO soDAO;

    public SocioControllerEmp(SociosVistaEmp vistaSocios) throws SQLException {
        this.vistaSocios = vistaSocios;
        soDAO = new SocioDAO();
    }

    public void inicializarTabla() throws SQLException {
        ArrayList<Socio> listaSocio = soDAO.obtenerTodos();
        vistaSocios.actualizarTabla(listaSocio);
    }

    public void eliminarSocioSeleccionado() throws SQLException {

        Socio socioSeleccionado = vistaSocios.socioSeleccionado();

        if (socioSeleccionado != null) {
            soDAO.delete(socioSeleccionado.getId());
            JOptionPane.showMessageDialog(vistaSocios, "Socio eliminado con éxito");
        } else {
            JOptionPane.showMessageDialog(vistaSocios, "No has seleccionado ningún socio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addSocio(Socio socio) throws SQLException {
        if (socio != null) {
            soDAO.create(socio);
            JOptionPane.showMessageDialog(vistaSocios, "Socio añadido con éxito");

            this.inicializarTabla();

        } else {
            JOptionPane.showMessageDialog(vistaSocios, "No se ha podido añadir el socio", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    

}
