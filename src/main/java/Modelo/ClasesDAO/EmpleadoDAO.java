 package Modelo.ClasesDAO;

import Modelo.Clases.Empleado;
import Modelo.Clases.Socio;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class EmpleadoDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public EmpleadoDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(Empleado empleado) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Empleado(nombre, apellidos, fecha_nacimiento, correo_electronico, telefono, direccion, fecha_alta, cargo, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        pSentencia.setString(1, empleado.getNombre());
        pSentencia.setString(2, empleado.getApellidos());
        pSentencia.setDate(3, (Date) empleado.getFecha_nacimiento());
        pSentencia.setString(4, empleado.getCorreo_electronico());
        pSentencia.setString(5, empleado.getTelefono());
        pSentencia.setString(6, empleado.getDireccion());
        pSentencia.setDate(7, (Date) empleado.getFecha_alta());
        pSentencia.setString(8, empleado.getCargo());
        pSentencia.setInt(9, empleado.getId_usuario());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;

    }

    public Empleado read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Empleado WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id = 0;
        String nombre = "";
        String apellidos = "";
        Date fechaNacimiento = null;
        String correo = "";
        String telefono = "";
        String direccion = "";
        Date fechaAlta = null;
        String cargo = "";
        int id_usuario = -1;

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
            cargo = rs.getString("cargo");
            id_usuario = rs.getInt("id_usuario");
            
        }

        Empleado empleado = new Empleado(id, nombre, apellidos, fechaNacimiento, correo, telefono, direccion, fechaAlta, id_usuario, cargo);
        return empleado;
    }

    public void update(Empleado empleado) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Empleado set nombre= ?, apellidos= ?, fecha_nacimiento= ?, correo_electronico = ?, telefono = ?, direccion = ?, fecha_alta = ?, cargo = ? WHERE id = ?");

        pSentencia.setString(1, empleado.getNombre());
        pSentencia.setString(2, empleado.getApellidos());
        pSentencia.setDate(3, (Date) empleado.getFecha_nacimiento());
        pSentencia.setString(4, empleado.getCorreo_electronico());
        pSentencia.setString(5, empleado.getTelefono());
        pSentencia.setString(6, empleado.getDireccion());
        pSentencia.setDate(7, (Date) empleado.getFecha_alta());
        pSentencia.setInt(8, empleado.getId_usuario());
        pSentencia.setString(9, empleado.getCargo());
        pSentencia.setInt(10, empleado.getId());

        pSentencia.executeUpdate();
    }

    public void delete(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Empleado WHERE ID = ?");
        pSentencia.setInt(1, clave);

        pSentencia.executeUpdate();
    }

    public ArrayList<Empleado> obtenerTodos() throws SQLException {
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Empleado");
        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String nombre = "";
        String apellidos = "";
        Date fechaNacimiento = null;
        String correo = "";
        String telefono = "";
        String direccion = "";
        Date fechaAlta = null;
        String cargo = "";
        int id_usuario = -1;

        while (rs.next()) {
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            apellidos = rs.getString("apellidos");
            fechaNacimiento = rs.getDate("fecha_nacimiento");
            correo = rs.getString("correo_electronico");
            telefono = rs.getString("telefono");
            direccion = rs.getString("direccion");
            fechaAlta = rs.getDate("fecha_alta");
            cargo = rs.getString("cargo");
            id_usuario = rs.getInt("id_usuario");
            
            Empleado empleado = new Empleado(id, nombre, apellidos, fechaNacimiento, correo, telefono, direccion, fechaAlta,id_usuario, cargo );
            listaEmpleados.add(empleado);
        }

        return listaEmpleados;
    }
}
