/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.TableModels;

import Modelo.Clases.Ejemplar;
import Modelo.Clases.Sucursal;
import Modelo.ClasesDAO.SucursalDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class EjemplarTableModel extends AbstractTableModel{

    private List<Ejemplar> listaEjemplares;
    private SucursalDAO suDAO;
    private List<Sucursal> listaSucursales;
    private String[] columnas = {"ID", "Estado", "Sucursal"};
    
    public EjemplarTableModel(List<Ejemplar> listaEjemplares) throws SQLException{
        this.listaEjemplares = listaEjemplares;
        suDAO = new SucursalDAO();
        listaSucursales = suDAO.obtenerTodas();
    }
    
    
    @Override
    public int getRowCount() {
        return listaEjemplares.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
public Object getValueAt(int rowIndex, int columnIndex) {
    Ejemplar ejemplar = listaEjemplares.get(rowIndex); // Obtienes el ejemplar de la lista

    switch (columnIndex) {
        case 0: 
            return ejemplar.getId();  // ID del ejemplar
        case 1: 
            return ejemplar.getEstado();  // Estado del ejemplar
        case 2: 
            // Buscar el nombre de la sucursal correspondiente al ID de sucursal
            int idSucursal = ejemplar.getId_sucursal();
            for (Sucursal sucursal : listaSucursales) {
                if (sucursal.getId() == idSucursal) {
                    return sucursal.getNombre();  // Devolver el nombre de la sucursal
                }
            }
            return "Sucursal no encontrada";  // Si no encuentras la sucursal, devuelves un mensaje
    }
    return null;
}


    public Ejemplar getEjemplarEnFila(int rowIndex){
        return listaEjemplares.get(rowIndex);
    }


    @Override
    public String getColumnName(int column) {
        return columnas[column];   
    }

    
}