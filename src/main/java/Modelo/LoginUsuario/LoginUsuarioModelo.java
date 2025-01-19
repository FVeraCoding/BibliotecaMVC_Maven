package Modelo.LoginUsuario;

import Modelo.Clases.Usuario;
import Modelo.ClasesDAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginUsuarioModelo {

    public int verificarLogueo(Usuario usuarioLogueado) throws SQLException {

        UsuarioDAO uDAO = new UsuarioDAO();

        ArrayList<Usuario> usuarios = uDAO.obtenerTodos();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(usuarioLogueado.getNombreUsuario())
                    && usuario.getPassword().equals(usuarioLogueado.getPassword())) {

                switch (usuario.getRol()) {
                    case "socio":
                        return 1;
                    case "empleado":
                        return 2;
                    case "administrador":
                        return 3;
                    default:
                        return -1;
                }
            }
        }

        return -1;
    }

    public Usuario usuarioLogueadoInfo(Usuario usuario) throws SQLException {
        UsuarioDAO uDAO = new UsuarioDAO();
        ArrayList<Usuario> usuarios = uDAO.obtenerTodos();

        for (Usuario usuarioLog : usuarios) {
            if (usuarioLog.getNombreUsuario().equalsIgnoreCase(usuario.getNombreUsuario())
                    && usuarioLog.getPassword().equals(usuario.getPassword())) {

                return usuarioLog;
            }
        }

        return null;
    }

}
