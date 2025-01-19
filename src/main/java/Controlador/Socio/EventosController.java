
package Controlador.Socio;

import Modelo.Clases.Evento;
import Modelo.ClasesDAO.EventoDAO;
import Vista.Socio.EventosVista;
import java.sql.SQLException;
import java.util.ArrayList;


public class EventosController {
    EventosVista vista;
    EventoDAO eveDAO;

    public EventosController(EventosVista vista) throws SQLException {
        this.vista = vista;
        this.eveDAO = new EventoDAO();
    }
    
    public void inicializarTabla() throws SQLException{
        ArrayList<Evento> listaEventos = eveDAO.obtenerTodos();
        vista.actualizarTabla(listaEventos);
    }
    
    
    
}
