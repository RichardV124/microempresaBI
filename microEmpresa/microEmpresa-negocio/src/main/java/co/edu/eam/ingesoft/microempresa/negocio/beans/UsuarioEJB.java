/**
 * 
 */
package co.edu.eam.ingesoft.microempresa.negocio.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.microempresa.negocio.persistencia.Persistencia;
import co.edu.ingesoft.microempresa.persistencia.entidades.Usuario;


/**
 * @author Monica Sepulveda & Carlos Martinez & Kevin Zapata
 *
 */
@LocalBean
@Stateless
public class UsuarioEJB {
	@EJB
	private Persistencia conexion;
	
	/**
	 * Buscar un usuario por username
	 * @param username el username del usuario a buscar
	 * @param bd base de datos en la que buscara
	 * @return el usuario en contrado, de lo contrario null
	 */
	public Usuario buscarByUsername(String username, int bd){
		conexion.setBd(bd);
		List<Object> lista = conexion.listarConParametroString(Usuario.buscarByUsername,username);
		if(lista.size() > 0){
			return (Usuario)lista.get(0);
		}else{
			return null;
		}
	}
}
