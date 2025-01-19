
package Controlador.Empleado;

import Modelo.Clases.Club;
import Modelo.Clases.Libro;
import Modelo.ClasesDAO.ClubDAO;
import Modelo.ClasesDAO.SocioDAO;
import Vista.Empleado.ClubVistaEmp;
import Vista.Socio.ClubVista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClubControllerEmp {
    ClubDAO cDAO;
    ClubVistaEmp vista;
    SocioDAO sDAO;

    public ClubControllerEmp(ClubVistaEmp vista) throws SQLException {
        this.vista = vista;
        cDAO = new ClubDAO();
        sDAO = new SocioDAO();
    }   
    
    public void inicializarTabla() throws SQLException{
        ArrayList<Club> listaClubs = cDAO.obtenerTodos();
        vista.actualizarTabla(listaClubs);
    }
    
    public void modificarClub() throws SQLException{
        sDAO.modificarClub(vista.getUsuarioLogueado().getId(), vista.clubSeleccionado().getId());
        JOptionPane.showMessageDialog(vista, "Te has inscrito correctamente al club.");
    }
    
    public void addClub(Club club) throws SQLException{
        if (club != null) {
            cDAO.create(club);
            JOptionPane.showMessageDialog(vista, "Club añadido con éxito");

            this.inicializarTabla();

        } else {
            JOptionPane.showMessageDialog(vista, "No se ha podido añadir el club", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void eliminarClubSeleccionado() throws SQLException {

        Club clubSeleccionado = vista.clubSeleccionado();

        if (clubSeleccionado != null) {
            cDAO.delete(clubSeleccionado.getId());
            JOptionPane.showMessageDialog(vista, "Club eliminado con éxito");
        } else {
            JOptionPane.showMessageDialog(vista, "No has seleccionado ningún club.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    
    
}
