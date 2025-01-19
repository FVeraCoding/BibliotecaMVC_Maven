package Modelo.ClasesDAO;

import Modelo.Clases.AsistenciaEventoEmpleado;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class AsistenciaEventoEmpleadoDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public AsistenciaEventoEmpleadoDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(AsistenciaEventoEmpleado asistencia) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Asistencia_Evento_Empleado(id_evento, id_empleado) VALUES (?, ?)");

        pSentencia.setInt(1, asistencia.getIdEvento());
        pSentencia.setInt(2, asistencia.getIdEmpleado());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;
    }

    public AsistenciaEventoEmpleado read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Asistencia_Evento_Empleado WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id_evento = 0;
        int id_empleado = 0;

        AsistenciaEventoEmpleado asistencia;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id_evento = rs.getInt("id_evento");
            id_empleado = rs.getInt("id_empleado");
        }

        asistencia = new AsistenciaEventoEmpleado(id_evento, id_empleado);
        return asistencia;
    }

    public void delete(int id_evento, int id_empleado) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Asistencia_Evento_Empleado WHERE id_evento = ? and id_empleado = ?");
        pSentencia.setInt(1, id_evento);
        pSentencia.setInt(2, id_empleado);

        pSentencia.executeUpdate();
    }

    public ArrayList<AsistenciaEventoEmpleado> obtenerTodos() throws SQLException {
        ArrayList<AsistenciaEventoEmpleado> listaAsistenciaEmpleados = new ArrayList<AsistenciaEventoEmpleado>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Asistencia_Evento_Empleado");
        ResultSet rs = pSentencia.executeQuery();

        int id_evento = 0;
        int id_empleado = 0;

        AsistenciaEventoEmpleado asistencia;

        while (rs.next()) {
            id_evento = rs.getInt("id_evento");
            id_empleado = rs.getInt("id_empleado");
            asistencia = new AsistenciaEventoEmpleado(id_evento, id_empleado);

            listaAsistenciaEmpleados.add(asistencia);
        }

        return listaAsistenciaEmpleados;
    }
}
