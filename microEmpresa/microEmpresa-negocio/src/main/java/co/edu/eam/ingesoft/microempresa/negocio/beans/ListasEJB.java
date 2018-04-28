package co.edu.eam.ingesoft.microempresa.negocio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.microempresa.negocio.persistencia.Persistencia;
import co.edu.ingesoft.microempresa.persistencia.entidades.Departamento;
import co.edu.ingesoft.microempresa.persistencia.entidades.Genero;
import co.edu.ingesoft.microempresa.persistencia.entidades.Municipio;

/**
 * 
 * @author Carlos Martinez
 * Se encarga de traer todos los registros de las tablas: Departamentos, Municipios, Generos
 */

@LocalBean
@Stateless
public class ListasEJB {

	@EJB
	private Persistencia conexion;
	
	/**
	 * Listar
	 * @param bd base de datos en la que obtendra los roles
	 * @return lista de roles
	 */
	public List<Departamento> listaDepartamentos(int bd){
		conexion.setBd(bd);
		// Lista de departamentos a retornar
		List<Departamento> listado = new ArrayList<Departamento>();
		// obtenemos la lista de objetos departamento de la base de datos
		List<Object> lista = conexion.listar(Departamento.listar);
		// recorremos la lista de objetos departamento
		for (Object object : lista) {
			// agregamos a la lista de departamentos, el objeto lo casteamos como objeto departamento
			listado.add((Departamento)object);
		}
		return listado;
	}
	
	/**
	 * Listar Municipios
	 * @param bd base de datos en la que obtendra los municipios
	 * @return lista de municipios
	 */
	public List<Municipio> listaMunicipios(int bd){
		conexion.setBd(bd);
		// Lista de municipios a retornar
		List<Municipio> listado = new ArrayList<Municipio>();
		// obtenemos la lista de objetos municipio de la base de datos
		List<Object> lista = conexion.listar(Municipio.listar);
		// recorremos la lista de objetos municipio
		for (Object object : lista) {
			// agregamos a la lista de municipio, el objeto lo casteamos como objeto municipio
			listado.add((Municipio)object);
		}
		return listado;
	}
	
	/**
	 * Listar Generos
	 * @param bd base de datos en la que obtendra los generos
	 * @return lista de generos
	 */
	public List<Genero> listaGeneros(int bd){
		conexion.setBd(bd);
		// Lista de generos a retornar
		List<Genero> listado = new ArrayList<Genero>();
		// obtenemos la lista de objetos generos de la base de datos
		List<Object> lista = conexion.listar(Genero.listarGeneros);
		// recorremos la lista de objetos genero
		for (Object object : lista) {
			// agregamos a la lista de generos, el objeto lo casteamos como objeto genero
			listado.add((Genero)object);
		}
		return listado;
	}
}
