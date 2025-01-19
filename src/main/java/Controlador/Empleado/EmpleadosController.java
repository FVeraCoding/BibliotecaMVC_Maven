package Controlador.Empleado;

import Modelo.Clases.Empleado;
import Modelo.ClasesDAO.EmpleadoDAO;
import Vista.Empleado.AddClubVista;
import Vista.Empleado.AddEventoVista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class EmpleadosController {

    EmpleadoDAO eDAO;
    AddEventoVista vistaEventos;
    AddClubVista vistaClubs;

    public EmpleadosController(AddEventoVista vistaEventos, AddClubVista vistaClubs) throws SQLException {
        this.eDAO = new EmpleadoDAO();
        this.vistaEventos = vistaEventos;
        this.vistaClubs = vistaClubs;
    }

    public void inicializarTabla() throws SQLException {
        ArrayList<Empleado> listaEmpleados = eDAO.obtenerTodos();
    }

    public void rellenarCombobox(JComboBox combo) throws SQLException {
        ArrayList<Empleado> listaEmpleados = eDAO.obtenerTodos();

        for (Empleado empleado : listaEmpleados) {
            combo.addItem(empleado.getId());
        }

    }

}
