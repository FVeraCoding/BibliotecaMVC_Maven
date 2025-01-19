package Modelo.ClasesDAO;

import Modelo.Clases.Socio;
import Modelo.Clases.Usuario;
import Modelo.Conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;

    public UsuarioDAO() throws SQLException {
        con = conexion.getConexion();
    }

    public boolean create(Usuario usuario) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("INSERT INTO Usuario(nombre_usuario, contraseña, rol) VALUES (?, ?, ?)");

        pSentencia.setString(1, usuario.getNombreUsuario());
        pSentencia.setString(2, usuario.getPassword());
        pSentencia.setString(3, usuario.getRol());

        int resultado = pSentencia.executeUpdate();

        return resultado != 0;

    }

    public Usuario read(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM USUARIO WHERE ID = ?");
        pSentencia.setInt(1, clave);

        int id = 0;
        String nombreUsuario = "";
        String password = "";
        String rol = "";
        Usuario usuario;

        ResultSet rs = pSentencia.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id");
            nombreUsuario = rs.getString("nombre_usuario");
            password = rs.getString("contraseña");
            rol = rs.getString("rol");
        }

        usuario = new Usuario(id, nombreUsuario, password, rol);
        return usuario;
    }

    public void update(Usuario usuario) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("UPDATE Usuario set nombre_usuario = ?, contraseña = ?, rol = ? WHERE id = ?");

        pSentencia.setString(1, usuario.getNombreUsuario());
        pSentencia.setString(2, usuario.getPassword());
        pSentencia.setString(3, usuario.getRol());
        pSentencia.setInt(4, usuario.getId());

        pSentencia.executeUpdate();
    }

    public void delete(int clave) throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("DELETE FROM Usuario WHERE ID = ?");
        pSentencia.setInt(1, clave);

        pSentencia.executeUpdate();
    }

    public ArrayList<Usuario> obtenerTodos() throws SQLException {
        ArrayList<Usuario> usuariosTodos = new ArrayList<Usuario>();
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM USUARIO");
        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String nombreUsuario = "";
        String password = "";
        String rol = "";

        while (rs.next()) {
            id = rs.getInt("id");
            nombreUsuario = rs.getString("nombre_usuario");
            password = rs.getString("contraseña");
            rol = rs.getString("rol");

            Usuario usuario = new Usuario(id, nombreUsuario, password, rol);
            usuariosTodos.add(usuario);
        }

        return usuariosTodos;
    }

    public int getUltimoID() throws SQLException {

        PreparedStatement pSentencia = con.prepareStatement("SELECT id FROM Usuario ORDER BY id DESC LIMIT 1");
        ResultSet rs = pSentencia.executeQuery();
        pSentencia.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }

        return -1;
    }

    public Usuario getUltimoUsuario() throws SQLException {
        PreparedStatement pSentencia = con.prepareStatement("SELECT * FROM Usuario ORDER BY id DESC LIMIT 1");

        ResultSet rs = pSentencia.executeQuery();

        int id = 0;
        String nombreUsuario = "";
        String password = "";
        String rol = "";

        while (rs.next()) {
            id = rs.getInt("id");
            nombreUsuario = rs.getString("nombre_usuario");
            password = rs.getString("contraseña");
            rol = rs.getString("rol");

        }
                    Usuario usuario = new Usuario(id, nombreUsuario, password, rol);
                    return usuario;
    }
    
}
