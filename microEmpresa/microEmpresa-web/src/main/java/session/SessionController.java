package session;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;


@Named("sessionController")
@SessionScoped
public class SessionController implements Serializable {
	
	/*
	 * Es la base de datos que actualmente esta utilizando el sistema
	 */
	private int bd;

	private String user;

	private String password;
	
	
	/*
	 * Iniciar Sesion
	 */
	public String login() {
		return "";
	}
	
	/*
	 * Cerrar Sesion
	 */
	public String logout() {
		return "/paginas/publico/login.xhtml?faces-redirect=true";
	}
	
}
