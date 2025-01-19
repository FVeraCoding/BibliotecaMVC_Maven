
package Controlador.Socio;

import Modelo.Clases.Club;
import Modelo.Clases.Socio;
import Modelo.ClasesDAO.ClubDAO;
import Modelo.ClasesDAO.SocioDAO;
import Vista.Socio.ClubVista;
import Vista.Socio.IntegrantesClubVista;
import java.sql.SQLException;
import java.util.ArrayList;


public class IntegrantesController {
    SocioDAO sDAO;
    IntegrantesClubVista vista;

    public IntegrantesController(IntegrantesClubVista vista) throws SQLException {
        this.vista = vista;
        sDAO = new SocioDAO();
    }   
    
    public void inicializarTabla() throws SQLException{
        ArrayList<Socio> listaSocios = sDAO.leerPorClub(vista.getIdClub());
        vista.actualizarTabla(listaSocios);
    }
    
    
}
