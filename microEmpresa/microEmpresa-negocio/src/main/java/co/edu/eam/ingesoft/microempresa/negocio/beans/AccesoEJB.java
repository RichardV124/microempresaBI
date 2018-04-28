package co.edu.eam.ingesoft.microempresa.negocio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.microempresa.negocio.persistencia.Persistencia;
import co.edu.ingesoft.microempresa.persistencia.entidades.Acceso;
import co.edu.ingesoft.microempresa.persistencia.entidades.Rol;

/**
 * 
 * @author carlos
 * Se encarga de todas las operaciones a la tabla accesos
 */
@LocalBean
@Stateless
public class AccesoEJB {
	
	@EJB
	private Persistencia conexion;
	
	/**
	 * Buscar Acceso por id
	 * @param id id del Acceso
	 * @param bd base de datos en la que buscara
	 * @return
	 */
	public Acceso buscar(int id, int bd){
		conexion.setBd(bd);
		return (Acceso) conexion.buscar(Acceso.class, id);
	}
	
	/**
	 * Listar Accesos
	 * @param bd base de datos en la que obtendra los accesos
	 * @return lista de accesos
	 */
	public List<Acceso> listar(int bd){
		conexion.setBd(bd);
		// Lista de accesos a retornar
		List<Acceso> listado = new ArrayList<Acceso>();
		// obtenemos la lista de objetos acceso de la base de datos
		List<Object> lista = conexion.listar(Acceso.listarAccesos);
		// recorremos la lista de objetos acceso
		for (Object object : lista) {
			// agregamos a la lista de acceso, el objeto lo casteamos como objeto acceso
			listado.add((Acceso)object);
		}
		return listado;
	}

}