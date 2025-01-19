package Controlador.Empleado;

import Modelo.Clases.AsistenciaEventoEmpleado;
import Modelo.Clases.AsistenciaEventoSocio;
import Modelo.ClasesDAO.AsistenciaEventoEmpleadoDAO;
import Modelo.ClasesDAO.AsistenciaEventoSocioDAO;
import Vista.Empleado.EventosVistaEmp;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AsistenciaEventoEmpleadoControllerEmp {

    AsistenciaEventoEmpleadoDAO aeeDAO;
    EventosVistaEmp vista;

    public AsistenciaEventoEmpleadoControllerEmp(EventosVistaEmp vista) throws SQLException {
        this.vista = vista;
        aeeDAO = new AsistenciaEventoEmpleadoDAO();
    }

    public void crearAsistencia() throws SQLException {

        int idEmpleado = vista.getUsuarioLogueado().getId();
        int idEvento = vista.eventoSeleccionado().getId();
        AsistenciaEventoEmpleado asistencia = new AsistenciaEventoEmpleado(idEvento, idEmpleado);
        aeeDAO.create(asistencia);
        JOptionPane.showMessageDialog(vista, "Asistencia registrada con éxito.");

    }
    
    public void eliminarAsistencia() throws SQLException{
        int idEmpleado = vista.getUsuarioLogueado().getId();
            int idEvento = vista.eventoSeleccionado().getId();

            AsistenciaEventoEmpleado asistencia = new AsistenciaEventoEmpleado(idEvento, idEmpleado);
            aeeDAO.delete(idEvento, idEmpleado);

            JOptionPane.showMessageDialog(vista, "Asistencia eliminada con éxito.");
    }

}
