
package Controlador.Socio;

import Modelo.Clases.Club;
import Modelo.ClasesDAO.ClubDAO;
import Modelo.ClasesDAO.SocioDAO;
import Vista.Socio.ClubVista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClubController {
    ClubDAO cDAO;
    ClubVista vista;
    SocioDAO sDAO;

    public ClubController(ClubVista vista) throws SQLException {
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
    
    
    
    
}
