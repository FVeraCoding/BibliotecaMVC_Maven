package Modelo.ClasesDAO;

import Modelo.Clases.Libro;
import Modelo.Clases.Sucursal;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class SucursalDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public SucursalDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(Sucursal sucursal) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Sucursal(nombre, direccion, telefono, hora_apertura, hora_cierre, capacidad) VALUES (?, ?, ?, ?, ?, ?)");

        pSentencia.setString(1, sucursal.getNombre());
        pSentencia.setString(2, sucursal.getDireccion());
        pSentencia.setString(3, sucursal.getTelefono());
        pSentencia.setTime(4, sucursal.getHoraApertura());
        pSentencia.setTime(5, sucursal.getHoraCierre());
        pSentencia.setInt(6, sucursal.getCapacidad());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;
    }

    public Sucursal read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Sucursal WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id = 0;
        String nombre = "";
        String direccion = "";
        String telefono = "";
        Time hora_apertura = null;
        Time hora_cierre = null;
        int capacidad = 0;

        Sucursal sucursal;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            direccion = rs.getString("direccion");
            telefono = rs.getString("telefono");
            hora_apertura = rs.getTime("hora_apertura");
            hora_cierre = rs.getTime("hora_cierre");
            capacidad = rs.getInt("capacidad");
        }

        sucursal = new Sucursal(id, nombre, direccion, telefono, hora_apertura, hora_cierre, capacidad);
        return sucursal;
    }

    public void update(Sucursal sucursal) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Sucursal set nombre = ?, direccion = ?, telefono = ?, hora_apertura = ?, hora_cierre = ?, capacidad = ? WHERE id = ?");

        pSentencia.setString(1, sucursal.getNombre());
        pSentencia.setString(2, sucursal.getDireccion());
        pSentencia.setString(3, sucursal.getTelefono());
        pSentencia.setTime(4, sucursal.getHoraApertura());
        pSentencia.setTime(5, sucursal.getHoraCierre());
        pSentencia.setInt(6, sucursal.getCapacidad());
        pSentencia.setInt(7, sucursal.getId());

        pSentencia.executeUpdate();
    }

    public void delete(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Sucursal WHERE ID = ?");
        pSentencia.setInt(1, clave);

        pSentencia.executeUpdate();
    }

    public ArrayList<Sucursal> obtenerTodas() throws SQLException {
        ArrayList<Sucursal> listaSucursales = new ArrayList<Sucursal>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Sucursal");
        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String nombre = "";
        String direccion = "";
        String telefono = "";
        Time hora_apertura = null;
        Time hora_cierre = null;
        int capacidad = 0;

        Sucursal sucursal;

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            direccion = rs.getString("direccion");
            telefono = rs.getString("telefono");
            hora_apertura = rs.getTime("hora_apertura");
            hora_cierre = rs.getTime("hora_cierre");
            capacidad = rs.getInt("capacidad");

            sucursal = new Sucursal(id, nombre, direccion, telefono, hora_apertura, hora_cierre, capacidad);
            listaSucursales.add(sucursal);
        }

        return listaSucursales;
    }
}
