package Modelo.ClasesDAO;

import Modelo.Clases.Evento;
import Modelo.Clases.Libro;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventoDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public EventoDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(Evento evento) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Evento(nombre, descripcion, fecha,  id_empleado_organizador, id_sucursal) VALUES (?, ?, ?, ?, ?)");

        pSentencia.setString(1, evento.getNombre());
        pSentencia.setString(2, evento.getDescripcion());
        pSentencia.setTimestamp(3, Timestamp.valueOf(evento.getFecha()));
        pSentencia.setInt(4, evento.getIdEmpleadoOrganizador());
        pSentencia.setInt(5, evento.getIdSucursal());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;

    }

    public Evento read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Evento WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id = 0;
        String nombre = "";
        String descripcion = "";
        LocalDateTime fecha = null;
        int idEmpleadoOrganizador = 0;
        int idSucursal = 0;

        Evento evento;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            descripcion = rs.getString("descripcion");
            fecha = rs.getTimestamp("fecha").toLocalDateTime();
            idEmpleadoOrganizador = rs.getInt("id_empleado_organizador");
            idSucursal = rs.getInt("id_sucursal");

        }

        evento = new Evento(id, nombre, descripcion, fecha, idEmpleadoOrganizador, idSucursal);
        return evento;
    }

    public void update(Evento evento) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Evento set nombre = ?, descripcion = ?, fecha= ?, id_empleado_organizador= ?, id_sucursal= ? WHERE id = ?");

        pSentencia.setString(1, evento.getNombre());
        pSentencia.setString(2, evento.getDescripcion());
        pSentencia.setTimestamp(3, Timestamp.valueOf(evento.getFecha()));
        pSentencia.setInt(4, evento.getIdEmpleadoOrganizador());
        pSentencia.setInt(5, evento.getIdSucursal());
        pSentencia.setInt(6, evento.getId());

        pSentencia.executeUpdate();
    }

    public void delete(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Evento WHERE ID = ?");
        pSentencia.setInt(1, clave);

        pSentencia.executeUpdate();
    }

    public ArrayList<Evento> obtenerTodos() throws SQLException {
        ArrayList<Evento> listaEventos = new ArrayList<Evento>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Evento");
        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String nombre = "";
        String descripcion = "";
        LocalDateTime fecha = null;
        int idEmpleadoOrganizador = 0;
        int idSucursal = 0;

        Evento evento;

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            descripcion = rs.getString("descripcion");
            fecha = rs.getTimestamp("fecha").toLocalDateTime();
            idEmpleadoOrganizador = rs.getInt("id_empleado_organizador");
            idSucursal = rs.getInt("id_sucursal");
            evento = new Evento(id, nombre, descripcion, fecha, idEmpleadoOrganizador, idSucursal);
            listaEventos.add(evento);
        }

        return listaEventos;

    }

}
