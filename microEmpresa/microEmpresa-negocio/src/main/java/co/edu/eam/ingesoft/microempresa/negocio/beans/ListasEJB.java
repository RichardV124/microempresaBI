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
import co.edu.ingesoft.microempresa.persistencia.entidades.Rol;

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
		return (List<Departamento>)(Object)conexion.listar(Departamento.listar);
	}
	
	/**
	 * Listar Municipios
	 * @param bd base de datos en la que obtendra los municipios
	 * @return lista de municipios
	 */
	public List<Municipio> listaMunicipios(int bd){
		conexion.setBd(bd);
		return (List<Municipio>)(Object)conexion.listar(Municipio.listar);
	}
	
	/**
	 * Listar Generos
	 * @param bd base de datos en la que obtendra los generos
	 * @return lista de generos
	 */
	public List<Genero> listaGeneros(int bd){
		conexion.setBd(bd);
		return (List<Genero>)(Object)conexion.listar(Genero.listarGeneros);
	}
}
