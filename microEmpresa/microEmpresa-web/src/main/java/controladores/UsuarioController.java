/**
 * 
 */
package controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import javax.enterprise.context.SessionScoped;

import co.edu.eam.ingesoft.microempresa.negocio.beans.UsuarioEJB;
import co.edu.ingesoft.microempresa.persistencia.entidades.Usuario;

/**
 * @author Carlos Martinez & Kevin Zapata & Monica Sepulveda
 *
 */
@Named("usuarioController")
@ViewScoped
public class UsuarioController implements Serializable{

	@EJB
	private UsuarioEJB usuarioEJB;
	
	private String username;
	
	private String password;
	
	private Usuario usuario;
	

	/**
	 * Iniciar sesion
	 */
	public void login() {
		if(username.isEmpty() || password.isEmpty()){
			Messages.addFlashGlobalError("Por favor, ingrese todos los campos");
		}else{
			Usuario u = usuarioEJB.buscarByUsername(username, 1);
			if(u != null){
				if(u.getPassword().equals(password)){
					usuario = u;
					Faces.setSessionAttribute("usuario", usuario);
					Messages.addFlashGlobalInfo("Ha iniciado sesion correctamente");
				}else{
					// Contraseña incorrecta
					Messages.addFlashGlobalError("Username o contraseña incorrectos");
				}
			}else{
				// Usuario no existe
				Messages.addFlashGlobalError("Username o contraseña incorrectos");
			}
		}
	}

	/**
	 * Cierra la sesion en la aplicacion
	 * @return la pagina de login
	 */
	public String cerrarSesion() {
		usuario = null;
		HttpSession sesion;
		sesion = (HttpSession) Faces.getSession();
		sesion.invalidate();
		return "/paginas/publico/login.xhtml?faces-redirect=true";
	}

	/**
	 * Determina si existe la sesion del usuario
	 * @return
	 */
	public boolean isSesion() {
		return usuario != null;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
