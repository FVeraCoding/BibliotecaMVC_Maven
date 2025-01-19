package Modelo.ClasesDAO;

import Modelo.Clases.Libro;
import Modelo.Clases.Usuario;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class LibroDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public LibroDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(Libro libro) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Libro(titulo, autor, editorial, genero, ISBN, anio_publicacion, imagen_url) VALUES (?, ?, ?, ?, ?, ?, ?)");

        pSentencia.setString(1, libro.getTitulo());
        pSentencia.setString(2, libro.getAutor());
        pSentencia.setString(3, libro.getEditorial());
        pSentencia.setString(4, libro.getGenero());
        pSentencia.setString(5, libro.getISBN());
        pSentencia.setDate(6, (Date) libro.getAnio_publicacion());
        pSentencia.setString(7, libro.getUrl());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;

    }

    public Libro read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Libro WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id = 0;
        String titulo = "";
        String autor = "";
        String editorial = "";
        String genero = "";
        String ISBN = "";
        Date anio = null;
        String url = "";

        Libro libro;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            titulo = rs.getString("titulo");
            autor = rs.getString("autor");
            editorial = rs.getString("editorial");
            genero = rs.getString("genero");
            ISBN = rs.getString("ISBN");
            anio = rs.getDate("anio_publicacion");
            url = rs.getString("imagen_url");

        }

        libro = new Libro(id, titulo, autor, editorial, genero, ISBN, anio, url);
        return libro;
    }

    public void update(Libro libro) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Libro set titulo = ?, autor = ?, editorial = ?, genero = ?, ISBN = ?, anio_publicacion = ? WHERE id = ?");

        pSentencia.setString(1, libro.getTitulo());
        pSentencia.setString(2, libro.getAutor());
        pSentencia.setString(3, libro.getEditorial());
        pSentencia.setString(4, libro.getGenero());
        pSentencia.setString(5, libro.getISBN());
        pSentencia.setDate(6, (Date) libro.getAnio_publicacion());

        pSentencia.executeUpdate();
    }

    public void delete(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Libro WHERE ID = ?");
        pSentencia.setInt(1, clave);

        pSentencia.executeUpdate();
    }

    public ArrayList<Libro> obtenerTodos() throws SQLException {
        ArrayList<Libro> librosTodos = new ArrayList<Libro>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Libro");
        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String titulo = "";
        String autor = "";
        String editorial = "";
        String genero = "";
        String ISBN = "";
        Date anio = null;
        String url = "";

        Libro libro;

        while (rs.next()) {
            id = rs.getInt("id");
            titulo = rs.getString("titulo");
            autor = rs.getString("autor");
            editorial = rs.getString("editorial");
            genero = rs.getString("genero");
            ISBN = rs.getString("ISBN");
            anio = rs.getDate("anio_publicacion");
            url = rs.getString("imagen_url");
            libro = new Libro(id, titulo, autor, editorial, genero, ISBN, anio, url);

            librosTodos.add(libro);

        }
        
        return librosTodos;
    }
}
