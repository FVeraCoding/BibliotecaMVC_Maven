package Controlador.Empleado;

import Modelo.Clases.Empleado;
import Modelo.Clases.Sucursal;
import Modelo.ClasesDAO.SucursalDAO;
import Vista.Empleado.AddEventoVista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class SucursalController {

    SucursalDAO suDAO;
    AddEventoVista vistaEventos;

    public SucursalController(AddEventoVista vistaEventos) throws SQLException {
        this.suDAO = new SucursalDAO();
        this.vistaEventos = vistaEventos;
    }

    public void inicializarTabla() throws SQLException {
        ArrayList<Sucursal> listaSucursal = suDAO.obtenerTodas();
    }

    public void rellenarCombobox(JComboBox combo) throws SQLException {
        ArrayList<Sucursal> listaSucursal = suDAO.obtenerTodas();

        for (Sucursal sucursal : listaSucursal) {
            combo.addItem(sucursal.getId());
        }

    }

}
