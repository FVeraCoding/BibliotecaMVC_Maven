package Controlador;

import Modelo.Clases.Usuario;
import Modelo.LoginUsuario.LoginUsuarioModelo;
import Vista.LoginVista;
import java.sql.SQLException;

public class LoginUsuarioController {

    LoginVista loginVista;
    LoginUsuarioModelo loginUsuarioModelo;

    public LoginUsuarioController(LoginVista lv) {
        this.loginVista = lv;
        this.loginUsuarioModelo = new LoginUsuarioModelo();
    }

    public void loginUsuario() throws SQLException {
        Usuario usuarioLogueado = loginVista.usuarioLogueado();

        switch (loginUsuarioModelo.verificarLogueo(usuarioLogueado)) {
            case 1:
                loginVista.abrirPantallaSocio(this.usuarioLogueado());
                break;
            case 2:
                loginVista.abrirPantallaEmpleado(this.usuarioLogueado());
                break;
            default:
                loginVista.mensajeError();
                break;
        }
    }

    public Usuario usuarioLogueado() throws SQLException {
        Usuario usuarioLogueado = loginVista.usuarioLogueado();
        usuarioLogueado = loginUsuarioModelo.usuarioLogueadoInfo(usuarioLogueado);

        if (usuarioLogueado != null) {
            return usuarioLogueado;

        } else {
            return null;
        }
    }
}
