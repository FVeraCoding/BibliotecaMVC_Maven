/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.TableModels;

import Modelo.Clases.Reserva;
import Modelo.ClasesDAO.ReservaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class ReservaTableModel extends AbstractTableModel{

    private List<Reserva> listaReservas;
    private ReservaDAO reDAO;
    private String[] columnas = {"Id socio", "Id ejemplar", "fecha inicio", "fecha fin"};
    
    public ReservaTableModel(List<Reserva> listaReservas) throws SQLException{
        this.listaReservas = listaReservas;
        reDAO = new ReservaDAO();
    }
    
    
    @Override
    public int getRowCount() {
        return listaReservas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
public Object getValueAt(int rowIndex, int columnIndex) {
    Reserva reserva = listaReservas.get(rowIndex);

    switch (columnIndex) {
        case 0: 
            return reserva.getIdSocio(); 
        case 1: 
            return reserva.getIdEjemplar();  
        case 2: 
            return reserva.getFechaInicio();
        case 3:
            return reserva.getFechaFin();
    }
    return null;
}

    @Override
    public String getColumnName(int column) {
        return columnas[column];   
    }    
}