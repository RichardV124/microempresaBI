/**
 * 
 */
package co.edu.eam.ingesoft.microempresa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.ingesoft.microempresa.persistencia.conexion.AdminsitradorConexion;
import co.edu.ingesoft.microempresa.persistencia.entidades.Genero;
import co.edu.ingesoft.microempresa.persistencia.entidades.Usuario;


/**
 * @author TOSHIBAP55W
 *
 */
@LocalBean
@Stateless
public class UsuarioEJB {

	
//	@PersistenceContext(unitName = "postgress")
//	private EntityManager em;
//	
	@PersistenceContext(unitName = "oracle")
	private EntityManager emO;
//	
//	@PersistenceContext(unitName = "mysql")
//	private EntityManager emMy;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Usuario buscarUsuario(String username) {
		EntityManager em = AdminsitradorConexion.getEntityManager();
		return em.find(Usuario.class, username);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Genero buscarGenero(int codigo) {
		//EntityManager em = AdminsitradorConexion.getEntityManager();
		return emO.find(Genero.class, codigo);
	}
}
