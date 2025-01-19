package Controlador.Empleado;

import Modelo.Clases.Reserva;
import Modelo.ClasesDAO.EjemplarDAO;
import Modelo.ClasesDAO.ReservaDAO;
import Vista.Empleado.MisReservasVistaEmp;
import Vista.Empleado.ReservarEjemplarVistaEmp;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReservasControllerEmp {

    ReservaDAO reDAO;
    EjemplarDAO ejeDAO;
    ReservarEjemplarVistaEmp vistaEjemplares;
    MisReservasVistaEmp vistaReservas;

    public ReservasControllerEmp(ReservarEjemplarVistaEmp vistaEjemplares, MisReservasVistaEmp vistaReservas) throws SQLException {
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
