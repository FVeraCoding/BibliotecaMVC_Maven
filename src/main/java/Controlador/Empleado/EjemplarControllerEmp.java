
package Controlador.Empleado;

import Modelo.Clases.Ejemplar;
import Modelo.Clases.Libro;
import Modelo.ClasesDAO.EjemplarDAO;
import Vista.Empleado.BuscarLibrosVistaEmp;
import Vista.Empleado.ReservarEjemplarVistaEmp;
import Vista.Socio.BuscarLibrosVista;
import Vista.Socio.ReservarEjemplarVista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class EjemplarControllerEmp {
    EjemplarDAO eDAO;
    BuscarLibrosVistaEmp vistaLibro;
    ReservarEjemplarVistaEmp vistaEjemplar;

    public EjemplarControllerEmp(BuscarLibrosVistaEmp vistaLibros, ReservarEjemplarVistaEmp vistaEjemplar) throws SQLException {
        this.eDAO = new EjemplarDAO();
        this.vistaLibro = vistaLibros;
        this.vistaEjemplar = vistaEjemplar;
    }
    
    public void inicializarTabla() throws SQLException{
        ArrayList<Ejemplar> listaEjemplares = eDAO.obtenerEjemplaresPorLibro(vistaLibro.libroSeleccionado().getId());
        vistaEjemplar.actualizarTabla(listaEjemplares);
    }
    
    public void addEjemplar(Ejemplar ejemplar) throws SQLException {
        if (ejemplar != null) {
            eDAO.create(ejemplar);
            JOptionPane.showMessageDialog(vistaEjemplar, "Ejemplar añadido con éxito");

            this.inicializarTabla();

        }
    }
    
        public void eliminarEjemplarSeleccionado() throws SQLException {

        Ejemplar ejemplarSeleccionado = vistaEjemplar.ejemplarSeleccionado();

        if (ejemplarSeleccionado != null) {
            eDAO.delete(ejemplarSeleccionado.getId());
            JOptionPane.showMessageDialog(vistaEjemplar, "Libro eliminado con éxito");
        } else {
            JOptionPane.showMessageDialog(vistaEjemplar, "No has seleccionado ningún libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
