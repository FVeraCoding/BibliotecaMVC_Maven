
package Controlador.Empleado;

import Modelo.Clases.Evento;
import Modelo.Clases.Libro;
import Modelo.ClasesDAO.EventoDAO;
import Vista.Empleado.EventosVistaEmp;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class EventosControllerEmp {
    EventosVistaEmp vista;
    EventoDAO eveDAO;

    public EventosControllerEmp(EventosVistaEmp vista) throws SQLException {
        this.vista = vista;
        this.eveDAO = new EventoDAO();
    }
    
    public void inicializarTabla() throws SQLException{
        ArrayList<Evento> listaEventos = eveDAO.obtenerTodos();
        vista.actualizarTabla(listaEventos);
    }
    
    public void addEvento(Evento evento) throws SQLException {
        if (evento != null) {
            eveDAO.create(evento);
            JOptionPane.showMessageDialog(vista, "Evento añadido con éxito");

            this.inicializarTabla();

        } else {
            JOptionPane.showMessageDialog(vista, "No se ha podido añadir el evento", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void eliminarEventoSeleccionado() throws SQLException {

        Evento eventoSeleccionado = vista.eventoSeleccionado();

        if (eventoSeleccionado != null) {
            eveDAO.delete(eventoSeleccionado.getId());
            JOptionPane.showMessageDialog(vista, "Evento eliminado con éxito");
        } else {
            JOptionPane.showMessageDialog(vista, "No has seleccionado ningún evento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
