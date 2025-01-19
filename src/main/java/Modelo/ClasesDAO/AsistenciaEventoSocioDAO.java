package Modelo.ClasesDAO;

import Modelo.Clases.AsistenciaEventoSocio;
import Modelo.Clases.Ejemplar;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class AsistenciaEventoSocioDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public AsistenciaEventoSocioDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(AsistenciaEventoSocio asistencia) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Asistencia_Evento_Socio(id_evento, id_socio) VALUES (?, ?)");

        pSentencia.setInt(1, asistencia.getIdEvento());
        pSentencia.setInt(2, asistencia.getIdSocio());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;
    }

    public AsistenciaEventoSocio read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Asistencia_Evento_Socio WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id_evento = 0;
        int id_socio = 0;

        AsistenciaEventoSocio asistencia;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id_evento = rs.getInt("id_evento");
            id_socio = rs.getInt("id_socio");
        }

        asistencia = new AsistenciaEventoSocio(id_evento, id_socio);
        return asistencia;
    }

    public void delete(int id_evento, int id_socio) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Asistencia_Evento_Socio WHERE id_evento = ? and id_socio = ?");
        pSentencia.setInt(1, id_evento);
        pSentencia.setInt(2, id_socio);

        pSentencia.executeUpdate();
    }

    public ArrayList<AsistenciaEventoSocio> obtenerTodos() throws SQLException {
        ArrayList<AsistenciaEventoSocio> listaAsistenciaSocios = new ArrayList<AsistenciaEventoSocio>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Asistencia_Evento_Socio");
        ResultSet rs = pSentencia.executeQuery();

        int id_evento = 0;
        int id_socio = 0;

        AsistenciaEventoSocio asistencia;

        while (rs.next()) {
            id_evento = rs.getInt("id_evento");
            id_socio = rs.getInt("id_socio");
            asistencia = new AsistenciaEventoSocio(id_evento, id_socio);

            listaAsistenciaSocios.add(asistencia);
        }

        return listaAsistenciaSocios;
    }
}
