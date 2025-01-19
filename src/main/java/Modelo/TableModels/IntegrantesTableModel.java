/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.TableModels;

import Modelo.Clases.Libro;
import Modelo.Clases.Socio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class IntegrantesTableModel extends AbstractTableModel {

    private List<Socio> listaSocios;
    private String[] columnas = {"Nombre", "Apellidos", "Correo electrónico"};

    public IntegrantesTableModel(List<Socio> listaSocios) {
        this.listaSocios = listaSocios;
    }

    public Socio getLibroEnFila(int rowIndex) {
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
        switch (columnIndex) {
            case 0:
                return listaSocios.get(rowIndex).getNombre();

            case 1:
                return listaSocios.get(rowIndex).getApellidos();

            case 2:
                return listaSocios.get(rowIndex).getCorreo_electronico();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
