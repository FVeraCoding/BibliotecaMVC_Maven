/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.TableModels;

import Modelo.Clases.Libro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class LibroTableModel extends AbstractTableModel {

    private List<Libro> listaLibros;
    private String[] columnas = {"Titulo", "Autor", "Editorial", "Genero", "ISBN", "Año"};

    public LibroTableModel(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public Libro getLibroEnFila(int rowIndex) {
        return listaLibros.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return listaLibros.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaLibros.get(rowIndex).getTitulo();

            case 1:
                return listaLibros.get(rowIndex).getAutor();

            case 2:
                return listaLibros.get(rowIndex).getEditorial();

            case 3:
                return listaLibros.get(rowIndex).getGenero();

            case 4:
                return listaLibros.get(rowIndex).getISBN();

            case 5:
                return listaLibros.get(rowIndex).getAnio_publicacion();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
