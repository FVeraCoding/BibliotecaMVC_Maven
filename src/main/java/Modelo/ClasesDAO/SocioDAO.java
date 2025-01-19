package Modelo.ClasesDAO;

import Modelo.Clases.Socio;
import Modelo.Clases.Usuario;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class SocioDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public SocioDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(Socio socio) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Socio(nombre, apellidos, fecha_nacimiento, correo_electronico, telefono, direccion, fecha_alta, id_usuario, id_club) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        pSentencia.setString(1, socio.getNombre());
        pSentencia.setString(2, socio.getApellidos());
        pSentencia.setDate(3, (Date) socio.getFecha_nacimiento());
        pSentencia.setString(4, socio.getCorreo_electronico());
        pSentencia.setString(5, socio.getTelefono());
        pSentencia.setString(6, socio.getDireccion());
        pSentencia.setDate(7, (Date) socio.getFecha_alta());
        pSentencia.setInt(8, socio.getId_usuario());
        pSentencia.setInt(9, socio.getId_club());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;

    }

    public Socio read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Socio WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id = 0;
        String nombre = "";
        String apellidos = "";
        Date fechaNacimiento = null;
        String correo = "";
        String telefono = "";
        String direccion = "";
        Date fechaAlta = null;
        int id_usuario = -1;
        int id_club = -1;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            apellidos = rs.getString("apellidos");
            fechaNacimiento = rs.getDate("fecha_nacimiento");
            correo = rs.getString("correo_electronico");
            telefono = rs.getString("telefono");
            direccion = rs.getString("direccion");
            fechaAlta = rs.getDate("fecha_alta");
            id_usuario = rs.getInt("id_usuario");
            id_club = rs.getInt("id_club");
        }

        Socio socio = new Socio(id, nombre, apellidos, fechaNacimiento, correo, telefono, direccion, fechaAlta, id_usuario, id_club);
        return socio;
    }

    public ArrayList<Socio> leerPorClub(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Socio WHERE id_club = ?");
        ArrayList<Socio> listaSocios = new ArrayList<Socio>();
        pSentencia.setInt(1, clave);

        int id = 0;
        String nombre = "";
        String apellidos = "";
        Date fechaNacimiento = null;
        String correo = "";
        String telefono = "";
        String direccion = "";
        Date fechaAlta = null;
        int id_usuario = -1;
        int id_club = -1;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            apellidos = rs.getString("apellidos");
            fechaNacimiento = rs.getDate("fecha_nacimiento");
            correo = rs.getString("correo_electronico");
            telefono = rs.getString("telefono");
            direccion = rs.getString("direccion");
            fechaAlta = rs.getDate("fecha_alta");
            id_usuario = rs.getInt("id_usuario");
            id_club = rs.getInt("id_club");

            Socio socio = new Socio(id, nombre, apellidos, fechaNacimiento, correo, telefono, direccion, fechaAlta, id_usuario, id_club);
            listaSocios.add(socio);
        }

        return listaSocios;
    }

    public void modificarClub(int idSocio, int idClub) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Socio set id_club = ? WHERE id = ?");

        pSentencia.setInt(1, idClub);
        pSentencia.setInt(2, idSocio);

        pSentencia.executeUpdate();

    }

    public void update(Socio socio) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Socio set nombre= ?, apellidos= ?, fecha_nacimiento= ?, correo_electronico = ?, telefono = ?, direccion = ?, fecha_alta = ? WHERE id = ?");

        pSentencia.setString(1, socio.getNombre());
        pSentencia.setString(2, socio.getApellidos());
        pSentencia.setDate(3, (Date) socio.getFecha_nacimiento());
        pSentencia.setString(4, socio.getCorreo_electronico());
        pSentencia.setString(5, socio.getTelefono());
        pSentencia.setString(6, socio.getDireccion());
        pSentencia.setDate(7, (Date) socio.getFecha_alta());
        pSentencia.setInt(8, socio.getId_usuario());
        pSentencia.setInt(9, socio.getId_club());

        pSentencia.executeUpdate();
    }

    public void delete(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Socio WHERE ID = ?");
        pSentencia.setInt(1, clave);

        pSentencia.executeUpdate();
    }

    public ArrayList<Socio> obtenerTodos() throws SQLException {
        ArrayList<Socio> listaSocios = new ArrayList<Socio>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Socio");
        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String nombre = "";
        String apellidos = "";
        Date fechaNacimiento = null;
        String correo = "";
        String telefono = "";
        String direccion = "";
        Date fechaAlta = null;
        int id_usuario = -1;
        int id_club = -1;

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            apellidos = rs.getString("apellidos");
            fechaNacimiento = rs.getDate("fecha_nacimiento");
            correo = rs.getString("correo_electronico");
            telefono = rs.getString("telefono");
            direccion = rs.getString("direccion");
            fechaAlta = rs.getDate("fecha_alta");
            id_usuario = rs.getInt("id_usuario");
            id_club = rs.getInt("id_club");

            Socio socio = new Socio(id, nombre, apellidos, fechaNacimiento, correo, telefono, direccion, fechaAlta, id_usuario, id_club);
            listaSocios.add(socio);
        }

        return listaSocios;
    }
}
