
package Modelo.ClasesDAO;

import Modelo.Clases.Reserva;
import Modelo.Clases.Usuario;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class ReservaDAO {
    ConexionBD conexion = new ConexionBD();
    Connection con;
    
    public ReservaDAO() throws SQLException{
        con = conexion.getConexion();
    }
    
    public boolean create(int id_socio, int id_ejemplar) throws SQLException{
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Reserva(id_socio, id_ejemplar, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)");
        
        pSentencia.setInt(1, id_socio);
        pSentencia.setInt(2, id_ejemplar);
        pSentencia.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
        pSentencia.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now().plusDays(20)));
        
        int resultado = pSentencia.executeUpdate();
        
        return resultado != 0; 
        
    }
    
    public ArrayList<Reserva> read(int clave) throws SQLException{
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Reserva WHERE id_socio = ? ");
        pSentencia.setInt(1, clave);
        
        ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
        
        int id_socio = 0;
        int id_ejemplar = 0;
        LocalDateTime fechaInicio;
        LocalDateTime fechaFin;
        
        ResultSet rs = pSentencia.executeQuery();
        
        while(rs.next()){
            id_socio = rs.getInt("id_socio");
            id_ejemplar = rs.getInt("id_ejemplar");
            fechaInicio = rs.getTimestamp("fecha_inicio").toLocalDateTime();
            fechaFin = rs.getTimestamp("fecha_fin").toLocalDateTime();
            
            Reserva reserva = new Reserva(id_socio, id_ejemplar, fechaInicio, fechaFin);
            listaReservas.add(reserva);
            
        }
        
        return listaReservas;
    }
    
    public void update(Reserva reserva) throws SQLException{
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Reserva set id_socio = ?, id_ejemplar = ?, fecha_inicio = ?, fecha_fin = ? WHERE id_socio = ?");
        
        pSentencia.setInt(1, reserva.getIdSocio());
        pSentencia.setInt(2, reserva.getIdEjemplar());
        pSentencia.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
        pSentencia.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now().plusDays(20)));
        
        pSentencia.executeUpdate();
    }
    
    
    public void delete(int id_socio, int id_ejemplar) throws SQLException{
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Reserva WHERE id_socio = ? and id_ejemplar = ?");
        pSentencia.setInt(1, id_socio);
        pSentencia.setInt(2, id_ejemplar);
        
        pSentencia.executeUpdate();
    }
    
    public ArrayList<Reserva> obtenerTodas() throws SQLException{
        ArrayList<Reserva> listaReservasGeneral = new ArrayList<Reserva>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM RESERVA");
        ResultSet rs = pSentencia.executeQuery();
        
        int id_socio = 0;
        int id_ejemplar = 0;
        LocalDateTime fechaInicio;
        LocalDateTime fechaFin;
        
        
        while(rs.next()){
            id_socio = rs.getInt("id_socio");
            id_ejemplar = rs.getInt("id_ejemplar");
            fechaInicio = rs.getTimestamp("fecha_inicio").toLocalDateTime();
            fechaFin = rs.getTimestamp("fecha_fin").toLocalDateTime();
            
            Reserva reserva = new Reserva(id_socio, id_ejemplar, fechaInicio, fechaFin);
            listaReservasGeneral.add(reserva);
            
        }
        
        return listaReservasGeneral;
    }
}
