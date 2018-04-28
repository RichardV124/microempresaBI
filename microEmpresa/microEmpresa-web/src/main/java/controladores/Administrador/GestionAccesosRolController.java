/**
 * 
 */
package controladores.Administrador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.microempresa.negocio.beans.AccesoEJB;
import co.edu.eam.ingesoft.microempresa.negocio.beans.AreaEmpresaEJB;
import co.edu.eam.ingesoft.microempresa.negocio.beans.AuditoriaEJB;
import co.edu.eam.ingesoft.microempresa.negocio.beans.RolEJB;
import co.edu.ingesoft.microempresa.persistencia.entidades.Acceso;
import co.edu.ingesoft.microempresa.persistencia.entidades.AreasEmpresa;
import co.edu.ingesoft.microempresa.persistencia.entidades.Auditoria;
import co.edu.ingesoft.microempresa.persistencia.entidades.Empresa;
import co.edu.ingesoft.microempresa.persistencia.entidades.Rol;
import co.edu.ingesoft.microempresa.persistencia.entidades.RolAcceso;
import excepciones.ExcepcionNegocio;
import session.SessionController;


/**
 * @author Monica Sepulveda & Kevin Zapata & Carlos Martinez
 * clase encargada de controlar la interfaz de gestionAccesosRol
 */


@ViewScoped
@Named("GestionAccesosRolController")
public class GestionAccesosRolController implements Serializable{
	
	@Inject
	private SessionController sesion;

	@EJB
	private RolEJB rolEJB;
	
	@EJB
	private AccesoEJB accesoEJB;
	
	private List<Rol> roles;
	
	private Rol rol;
	
	private List<Acceso> accesos;
	
	private Acceso acceso;
	
	private List<RolAcceso> rolAccesos;
	
	@PostConstruct
	public void inicializar(){
		listar();
	}
	
	/**
	 * Otorga el acceso a un rol
	 */
	public void otorgar(){
		
	}
	
	/**
	 * Quita el permiso a un rol
	 */
	public void quitar(RolAcceso rolAcceso){
		
	}
	
	/**
	 * Listar en los combobox
	 */
	public void listar(){
		roles = rolEJB.listar(sesion.getBd());
		accesos = accesoEJB.listar(sesion.getBd());
	}

	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
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
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * @return the acceso
	 */
	public Acceso getAcceso() {
		return acceso;
	}

	/**
	 * @param acceso the acceso to set
	 */
	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	/**
	 * @return the rolAccesos
	 */
	public List<RolAcceso> getRolAccesos() {
		return rolAccesos;
	}

	/**
	 * @param rolAccesos the rolAccesos to set
	 */
	public void setRolAccesos(List<RolAcceso> rolAccesos) {
		this.rolAccesos = rolAccesos;
	}
	
}
