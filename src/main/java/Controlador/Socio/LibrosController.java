
package Controlador.Socio;

import Modelo.Clases.Libro;
import Modelo.ClasesDAO.LibroDAO;
import Vista.Socio.BuscarLibrosVista;
import java.sql.SQLException;
import java.util.ArrayList;


public class LibrosController {
    BuscarLibrosVista vistaLibros;
    LibroDAO lDAO;

    public LibrosController(BuscarLibrosVista vistaLibros) throws SQLException {
        this.vistaLibros = vistaLibros;
        lDAO = new LibroDAO();
    }
    
    public void inicializarTabla() throws SQLException{
        ArrayList<Libro> listaLibros = lDAO.obtenerTodos();
        vistaLibros.actualizarTabla(listaLibros); 
    }
    
    
    
    
}
