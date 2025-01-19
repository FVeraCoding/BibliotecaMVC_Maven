/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.TableModels;

import Modelo.Clases.Ejemplar;
import Modelo.Clases.Empleado;
import Modelo.Clases.Evento;
import Modelo.Clases.Sucursal;
import Modelo.ClasesDAO.EmpleadoDAO;
import Modelo.ClasesDAO.EventoDAO;
import Modelo.ClasesDAO.SucursalDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class EventoTableModel extends AbstractTableModel {

    private List<Evento> listaEventos;
    private EventoDAO eveDAO;
    private EmpleadoDAO empDAO;
    private SucursalDAO suDAO;
    private List<Sucursal> listaSucursales;
    private List<Empleado> listaEmpleados;
    private String[] columnas = {"Nombre", "Descripción", "fecha", "Empleado organizador", "Sucursal"};

    public EventoTableModel(List<Evento> listaEvento) throws SQLException {
        eveDAO = new EventoDAO();
        suDAO = new SucursalDAO();
        empDAO = new EmpleadoDAO();
        this.listaEventos = listaEvento;
        this.listaEmpleados = empDAO.obtenerTodos();

        listaSucursales = suDAO.obtenerTodas();
    }

    @Override
    public int getRowCount() {
        return listaEventos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Evento evento = listaEventos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return evento.getNombre();
            case 1:
                return evento.getDescripcion();
            case 2:
                return evento.getFecha();
            case 3:
                int idEmpleado = evento.getIdEmpleadoOrganizador();
                for (Empleado empleado : listaEmpleados) {
                    if (empleado.getId() == idEmpleado) {
                        return empleado.getNombre();
                    }
                }

            case 4:

                int idSucursal = evento.getIdSucursal();
                for (Sucursal sucursal : listaSucursales) {
                    if (sucursal.getId() == idSucursal) {
                        return sucursal.getNombre();
                    }
                }
                return "Sucursal no encontrada";
        }
        return null;
    }

    public Evento getEventoEnFila(int rowIndex) {
        return listaEventos.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    


}
