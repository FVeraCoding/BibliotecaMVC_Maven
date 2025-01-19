
package Controlador.Empleado;

import Modelo.Clases.Club;
import Modelo.Clases.Socio;
import Modelo.Clases.Usuario;
import Modelo.ClasesDAO.ClubDAO;
import Modelo.ClasesDAO.UsuarioDAO;
import Vista.Empleado.AddSocioVista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class UsuarioControllerEmp {

    AddSocioVista vista;
    UsuarioDAO uDAO;

    public UsuarioControllerEmp(AddSocioVista vista) throws SQLException {
        this.vista = vista;
        uDAO = new UsuarioDAO();
       
    }
    
    public int getUltimoID() throws SQLException{
        return uDAO.getUltimoID();
    }
    
    public Usuario getUltimoUsuario() throws SQLException{
        return uDAO.getUltimoUsuario();
    }
    
    public void addUsuario(Usuario usuario) throws SQLException {
            boolean creado = uDAO.create(usuario);
            
            System.out.println(creado);
            
    }
    
}
