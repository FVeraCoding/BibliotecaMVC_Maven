package Controlador.Socio;

import Modelo.Clases.AsistenciaEventoSocio;
import Modelo.ClasesDAO.AsistenciaEventoSocioDAO;
import Vista.Socio.EventosVista;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.SQLIntegrityConstraintViolationException;

public class AsistenciaEventoSocioController {

    AsistenciaEventoSocioDAO aesDAO;
    EventosVista vista;

    public AsistenciaEventoSocioController(EventosVista vista) throws SQLException {
        this.vista = vista;
        aesDAO = new AsistenciaEventoSocioDAO();
    }

    public void crearAsistencia() throws SQLException {

        try {

            int idSocio = vista.getUsuarioLogueado().getId();
            System.out.println(idSocio);
            int idEvento = vista.eventoSeleccionado().getId();

            AsistenciaEventoSocio asistencia = new AsistenciaEventoSocio(idEvento, idSocio);
            aesDAO.create(asistencia);

            JOptionPane.showMessageDialog(vista, "Asistencia registrada con éxito.");

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Ya estás apuntado al evento. ",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void eliminarAsistencia() throws SQLException{
        int idSocio = vista.getUsuarioLogueado().getId();
            int idEvento = vista.eventoSeleccionado().getId();

            AsistenciaEventoSocio asistencia = new AsistenciaEventoSocio(idEvento, idSocio);
            aesDAO.delete(idEvento, idSocio);

            JOptionPane.showMessageDialog(vista, "Asistencia eliminada con éxito.");
    }

}
