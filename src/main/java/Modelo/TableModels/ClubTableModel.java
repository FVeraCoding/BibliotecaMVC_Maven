/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.TableModels;

import Modelo.Clases.Club;
import Modelo.Clases.Ejemplar;
import Modelo.Clases.Empleado;
import Modelo.Clases.Sucursal;
import Modelo.ClasesDAO.ClubDAO;
import Modelo.ClasesDAO.EmpleadoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class ClubTableModel extends AbstractTableModel {

    private List<Club> listaClubs;
    ClubDAO cDAO;
    EmpleadoDAO empDAO;
    private List<Empleado> listaEmpleados;
    private String[] columnas = {"Nombre", "Descripcion", "Fecha creación", "Empleado gestionador"};

    public ClubTableModel(List<Club> listaClubs) throws SQLException {
        this.listaClubs = listaClubs;
        cDAO = new ClubDAO();
        empDAO = new EmpleadoDAO();
        listaEmpleados = empDAO.obtenerTodos();
        listaClubs = cDAO.obtenerTodos();
    }

    @Override
    public int getRowCount() {
        return listaClubs.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Club club = listaClubs.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return club.getNombre();
            case 1:
                return club.getDescripcion();
            case 2:
                return club.getFechaCreacion();
            case 3:
                int idEmpleado = club.getIdEmpleadoGestor();
                
                for (Empleado empleado : listaEmpleados) {
                    if (empleado.getId() == idEmpleado) {
                        return empleado.getNombre();
                    }
                    
                }
                return null;
        }
        
        return club;
    }
    
    

    public Club getClubEnFila(int rowIndex) {
        return listaClubs.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
