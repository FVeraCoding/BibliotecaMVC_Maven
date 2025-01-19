package Modelo.ClasesDAO;

import Modelo.Clases.Club;
import Modelo.Clases.Ejemplar;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class ClubDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public ClubDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(Club club) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Club(nombre, descripcion, fecha_creacion, id_empleado_gestion ) VALUES (?, ?, ?, ?)");

        pSentencia.setString(1, club.getNombre());
        pSentencia.setString(2, club.getDescripcion());
        pSentencia.setDate(3, (Date) club.getFechaCreacion());
        pSentencia.setInt(4, club.getIdEmpleadoGestor());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;
    }

    public Club read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Club WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id = 0;
        String nombre = "";
        String descripcion = "";
        Date fechaCreacion = null;
        int idEmpleadoGestor = 0;

        Club club;
        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            descripcion = rs.getString("descripcion");
            fechaCreacion = rs.getDate("fecha_creacion");
            idEmpleadoGestor = rs.getInt("id_empleado_gestion");

        }

        club = new Club(id, nombre, descripcion, fechaCreacion, idEmpleadoGestor);
        return club;
    }

    public void update(Club club) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Club set nombre = ?, descripcion = ?, fecha_creacion = ?, id_empleado_gestion = ? WHERE id = ?");

        pSentencia.setString(1, club.getNombre());
        pSentencia.setString(2, club.getDescripcion());
        pSentencia.setDate(3, (Date) club.getFechaCreacion());
        pSentencia.setInt(4, club.getIdEmpleadoGestor());
        pSentencia.setInt(5, club.getId());

        pSentencia.executeUpdate();
    }

    public void delete(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Club WHERE ID = ?");
        pSentencia.setInt(1, clave);

        pSentencia.executeUpdate();
    }

    public ArrayList<Club> obtenerTodos() throws SQLException {
        ArrayList<Club> listaClubs = new ArrayList<Club>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Club");
        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String nombre = "";
        String descripcion = "";
        Date fechaCreacion = null;
        int idEmpleadoGestor = 0;

        Club club;
        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            descripcion = rs.getString("descripcion");
            fechaCreacion = rs.getDate("fecha_creacion");
            idEmpleadoGestor = rs.getInt("id_empleado_gestion");
            
            club = new Club(id, nombre, descripcion, fechaCreacion, idEmpleadoGestor);
            listaClubs.add(club);
        }

        return listaClubs;
    }
}
