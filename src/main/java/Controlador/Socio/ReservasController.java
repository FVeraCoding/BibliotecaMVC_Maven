package Controlador.Socio;

import Modelo.Clases.Reserva;
import Modelo.ClasesDAO.EjemplarDAO;
import Modelo.ClasesDAO.ReservaDAO;
import Vista.Socio.MisReservasVista;
import Vista.Socio.ReservarEjemplarVista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReservasController {

    ReservaDAO reDAO;
    EjemplarDAO ejeDAO;
    ReservarEjemplarVista vistaEjemplares;
    MisReservasVista vistaReservas;

    public ReservasController(ReservarEjemplarVista vistaEjemplares, MisReservasVista vistaReservas) throws SQLException {
        reDAO = new ReservaDAO();
        ejeDAO = new EjemplarDAO();
        this.vistaEjemplares = vistaEjemplares;
        this.vistaReservas = vistaReservas;
    }

    public void crearReserva() throws SQLException {
        int idSocio = vistaEjemplares.getUsuarioLogueado().getId();
        System.out.println(idSocio);
        int idEjemplar = vistaEjemplares.ejemplarSeleccionado().getId();
        
        System.out.println(vistaEjemplares.ejemplarSeleccionado().toString());

        if (!vistaEjemplares.ejemplarSeleccionado().getEstado().equals("Reservado")) {
            reDAO.create(idSocio, idEjemplar);

            vistaEjemplares.ejemplarSeleccionado().setEstado("Reservado");
            ejeDAO.update(vistaEjemplares.ejemplarSeleccionado());
            
            vistaEjemplares.getTableModel().fireTableDataChanged();
            JOptionPane.showMessageDialog(vistaEjemplares, "Reserva realizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(vistaEjemplares, "Este ejemplar ya ha sido reservado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarReservasUsuario(int idUsuario) throws SQLException{        
        
        ArrayList<Reserva> reservasUsuario = reDAO.read(idUsuario);
        vistaReservas.actualizarTabla(reservasUsuario);
        
    }

}
