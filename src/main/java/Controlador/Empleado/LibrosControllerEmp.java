package Controlador.Empleado;

import Modelo.Clases.Libro;
import Modelo.ClasesDAO.LibroDAO;
import Vista.Empleado.BuscarLibrosVistaEmp;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LibrosControllerEmp {

    BuscarLibrosVistaEmp vistaLibros;
    LibroDAO lDAO;

    public LibrosControllerEmp(BuscarLibrosVistaEmp vistaLibros) throws SQLException {
        this.vistaLibros = vistaLibros;
        lDAO = new LibroDAO();
    }

    public void inicializarTabla() throws SQLException {
        ArrayList<Libro> listaLibros = lDAO.obtenerTodos();
        vistaLibros.actualizarTabla(listaLibros);
    }

    public void eliminarLibroSeleccionado() throws SQLException {

        Libro libroSeleccionado = vistaLibros.libroSeleccionado();

        if (libroSeleccionado != null) {
            lDAO.delete(libroSeleccionado.getId());
            JOptionPane.showMessageDialog(vistaLibros, "Libro eliminado con éxito");
        } else {
            JOptionPane.showMessageDialog(vistaLibros, "No has seleccionado ningún libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addLibro(Libro libro) throws SQLException {
        if (libro != null) {
            lDAO.create(libro);
            JOptionPane.showMessageDialog(vistaLibros, "Libro añadido con éxito");

            this.inicializarTabla();

        } else {
            JOptionPane.showMessageDialog(vistaLibros, "No se ha podido añadir el libro", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

}
