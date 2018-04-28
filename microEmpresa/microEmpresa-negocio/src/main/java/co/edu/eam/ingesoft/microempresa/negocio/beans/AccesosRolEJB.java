package co.edu.eam.ingesoft.microempresa.negocio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.microempresa.negocio.persistencia.Persistencia;
import co.edu.ingesoft.microempresa.persistencia.entidades.Acceso;
import co.edu.ingesoft.microempresa.persistencia.entidades.Rol;
import co.edu.ingesoft.microempresa.persistencia.entidades.RolAcceso;

/**
 * 
 * @author carlos
 * Se encarga de todas las operaciones a la tabla accesos
 */
@LocalBean
@Stateless
public class AccesosRolEJB {

	@EJB
	private Persistencia conexion;
	
	/**
	 * Listar Accesos por Rol
	 * @param bd base de datos en la que obtendra los accesos por rol
	 * @return lista de accesos de un determinado rol
	 */
	public List<Acceso> listarByRol(Rol rol, int bd){
		conexion.setBd(bd);
		// Lista de roles a retornar
		List<Acceso> listado = new ArrayList<Acceso>();
		// obtenemos la lista de objetos rol de la base de datos
		List<Object> lista = conexion.listarConParametroInteger(RolAcceso.listarAccesosByRol, rol.getCodigo());
		// recorremos la lista de objetos rol
		for (Object object : lista) {
			RolAcceso ra = (RolAcceso)object;
			// agregamos a la lista de roles, el objeto lo casteamos como objeto rol
			listado.add(ra.getAcceso());
		}
		return listado;
	}
	
}
