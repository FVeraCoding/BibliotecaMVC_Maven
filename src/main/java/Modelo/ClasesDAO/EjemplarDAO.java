package Modelo.ClasesDAO;

import Modelo.Clases.Ejemplar;
import Modelo.Clases.Sucursal;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class EjemplarDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public EjemplarDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(Ejemplar ejemplar) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Ejemplar(estado, id_sucursal, id_libro) VALUES (?, ?, ?)");

        pSentencia.setString(1, ejemplar.getEstado());
        pSentencia.setInt(2, ejemplar.getId_sucursal());
        pSentencia.setInt(3, ejemplar.getId_libro());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;
    }

    public Ejemplar read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Ejemplar WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id = 0;
        String estado = "";
        int id_sucursal = 0;
        int id_libro = 0;

        Ejemplar ejemplar;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            estado = rs.getString("estado");
            id_sucursal = rs.getInt("id_sucursal");
            id_libro = rs.getInt("id_libro");

        }

        ejemplar = new Ejemplar(id, estado, id_sucursal, id_libro);
        return ejemplar;
    }

    public void update(Ejemplar ejemplar) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Ejemplar set estado = ?, id_sucursal = ?, id_libro = ? WHERE id = ?");

        pSentencia.setString(1, ejemplar.getEstado());
        pSentencia.setInt(2, ejemplar.getId_sucursal());
        pSentencia.setInt(3, ejemplar.getId_libro());
        pSentencia.setInt(4, ejemplar.getId());

        pSentencia.executeUpdate();
    }

    public void delete(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Ejemplar WHERE ID = ?");
        pSentencia.setInt(1, clave);

        pSentencia.executeUpdate();
    }

    public ArrayList<Ejemplar> obtenerTodos() throws SQLException {
        ArrayList<Ejemplar> listaEjemplares = new ArrayList<Ejemplar>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Ejemplar");
        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String estado = "";
        int id_sucursal = 0;
        int id_libro = 0;

        Ejemplar ejemplar;

        while (rs.next()) {
            id = rs.getInt("id");
            estado = rs.getString("estado");
            id_sucursal = rs.getInt("id_sucursal");
            id_libro = rs.getInt("id_libro");

            ejemplar = new Ejemplar(id, estado, id_sucursal, id_libro);

            listaEjemplares.add(ejemplar);
        }

        return listaEjemplares;
    }

    public ArrayList<Ejemplar> obtenerEjemplaresPorLibro(int idLibro) throws SQLException {
        ArrayList<Ejemplar> ejemplares = new ArrayList<>();

        String query = "SELECT * FROM Ejemplar WHERE id_libro = ?";

        PreparedStatement pst = con.prepareStatement(query);
            
        pst.setInt(1, idLibro);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Ejemplar ejemplar = new Ejemplar(
                    rs.getInt("id"),
                    rs.getString("estado"),
                    rs.getInt("id_sucursal"),
                    rs.getInt("id_libro")
            );
            ejemplares.add(ejemplar);
        }
            return ejemplares ;
    }
}

