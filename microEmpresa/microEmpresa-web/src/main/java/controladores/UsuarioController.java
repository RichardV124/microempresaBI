/**
 * 
 */
package controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;


import co.edu.eam.ingesoft.microempresa.negocio.beans.UsuarioEJB;
import co.edu.ingesoft.microempresa.persistencia.entidades.Genero;
import co.edu.ingesoft.microempresa.persistencia.entidades.Usuario;

/**
 * @author TOSHIBAP55W
 *
 */
@Named("usuarioController")
@ViewScoped
public class UsuarioController implements Serializable{

	@EJB
	private UsuarioEJB usuarioEJB;
	
	private String username;
	
	private String password;
	
	private String dataBase;
	

	
	public void login() {
//		usuarioEJB =  new UsuarioEJB(dataBase);
		try{
		if(username.isEmpty()){
			Messages.addFlashGlobalError("ingrese informacion");
		}else{
		
		Genero u = usuarioEJB.buscarGenero(Integer.parseInt(username));
		if (u== null){
			Messages.addFlashGlobalError("Usuario INCORRECTO");
			System.out.print("Usuario INCORRECTO");	
		}else{
			Messages.addFlashGlobalInfo("EL username es = "+u.getNombre()+" , y la contraseña es = "+u.getCodigo()+"");
			//Messages.addFlashGlobalInfo("EL username es = "+u.getUsername()+" , y la contraseña es = "+u.getPassword()+"");
		//	System.out.println("EL username es = "+u.getUsername()+" , y la contraseña es = "+u.getPassword()+"");
		}
//		System.out.println("EL username es = "+u.getUsername()+" , y la contraseña es = "+u.getPassword()+"");
//		return "EL username es = "+u.getUsername()+" , y la contraseña es = "+u.getPassword()+"";	
//	}
		}
		}catch (NumberFormatException ex){
			Messages.addFlashGlobalError("solo datos numericos");
		}
	}

	
	
	/**
	 * @return the dataBase
	 */
	public String getDataBase() {
		return dataBase;
	}



	/**
	 * @param dataBase the dataBase to set
	 */
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
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
	
	
}
