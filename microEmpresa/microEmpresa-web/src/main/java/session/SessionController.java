package session;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.microempresa.negocio.beans.EmpresaEJB;
import co.edu.eam.ingesoft.microempresa.negocio.beans.UsuarioEJB;
import co.edu.eam.ingesoft.microempresa.negocio.beansSeguridad.SeguridadEJB;
import co.edu.ingesoft.microempresa.persistencia.entidades.Acceso;
import co.edu.ingesoft.microempresa.persistencia.entidades.Rol;
import co.edu.ingesoft.microempresa.persistencia.entidades.Usuario;


@Named("sessionController")
@SessionScoped
public class SessionController implements Serializable {

	@EJB
	private UsuarioEJB usuarioEJB;
	
	@EJB
	private SeguridadEJB seguridadEJB;
	
	@EJB
	private EmpresaEJB empresaEJB;
	
	private String username;
	
	private String password;
	
	/**
	 * Es la base de datos que el sistema esta usando actualmente
	 */
	private int bd;
	
	/**
	 * El usuario que ha iniciado sesion en la aplicacion
	 */
	private Usuario usuario;

	/**
	 * Listado de accesos que tiene el usuario que inicio sesion
	 */
	private List<Acceso> accesos;

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
					accesos = seguridadEJB.listarAccesosRol(usuario.getPersona().getRol(), 1);
					Faces.setSessionAttribute("usuario", usuario);
					// Buscamos en que bd esta trabajando el sistema, buscamos en la base de datos por defecto
					// que es oracle, y despues la guardamos como variable de sesion
					bd = empresaEJB.buscar(1, 1).getBd();
					Faces.setSessionAttribute("bd", bd);
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

	/**
	 * @return the accesos
	 */
	public List<Acceso> getAccesos() {
		return accesos;
	}

	/**
	 * @param accesos the accesos to set
	 */
	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	/**
	 * @return the bd
	 */
	public int getBd() {
		return 1;
	}

	/**
	 * @param bd the bd to set
	 */
	public void setBd(int bd) {
		this.bd = bd;
	}	
	
}
