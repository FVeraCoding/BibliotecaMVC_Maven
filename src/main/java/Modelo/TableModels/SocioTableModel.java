/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.TableModels;

import Modelo.Clases.Reserva;
import Modelo.Clases.Socio;
import Modelo.ClasesDAO.ReservaDAO;
import Modelo.ClasesDAO.SocioDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class SocioTableModel extends AbstractTableModel{

    private List<Socio> listaSocios;
    private SocioDAO soDAO;
    private String[] columnas = {"Id", "Nombre", "Apellidos", "Fecha de Nacimiento", "Correo Electrónico", "Teléfono", "Dirección", "Fecha_alta", "ID de usuario"};
    
    public SocioTableModel(List<Socio> listaSocios) throws SQLException{
        this.listaSocios = listaSocios;
        soDAO = new SocioDAO();
    }
    
    public Socio getSocioEnFila(int rowIndex) {
        return listaSocios.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return listaSocios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
public Object getValueAt(int rowIndex, int columnIndex) {
    Socio socio = listaSocios.get(rowIndex);

    switch (columnIndex) {
        case 0: 
            return socio.getId(); 
        case 1: 
            return socio.getNombre();  
        case 2: 
            return socio.getApellidos();
        case 3:
            return socio.getFecha_nacimiento();
        case 4:
            return socio.getCorreo_electronico();
        case 5:
            return socio.getTelefono();
        case 6:
            return socio.getDireccion();
        case 7:
            return socio.getFecha_alta();
        case 8:
            return socio.getId_usuario();
        
        
    }
    return null;
}

    @Override
    public String getColumnName(int column) {
        return columnas[column];   
    }    
}