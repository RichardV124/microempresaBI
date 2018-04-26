/**
 * 
 */
package co.edu.ingesoft.microempresa.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author TOSHIBAP55W
 *
 */
@Entity
@Table(name="Accesos")
@NamedQueries({
	@NamedQuery(name=Acceso.listarAccesos,query="SELECT a FROM Acceso a"),
	@NamedQuery(name=Acceso.listarAccesosByRol,query="SELECT a FROM Acceso a WHERE a.rol.codigo=?1")
})
public class Acceso implements Serializable{

	public static final String listarAccesos = "Rol.listarAccesos";
	public static final String listarAccesosByRol = "Rol.listarAccesosByRol";
	
	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCESO_SEQ")
    @SequenceGenerator(sequenceName = "acceso_seq", allocationSize = 1, name = "ACCESO_SEQ")
	private int codigo;
	
	@Column(name="nombre_acceso",length=60,nullable=false)
	private String nombreAcceso;
	
	@Column(name="url",length=60,nullable=false)
	private String url;
	
	@ManyToOne
	@JoinColumn(name="rol")
	private Rol rol;
	
	public Acceso (){
		
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombreAcceso
	 */
	public String getNombreAcceso() {
		return nombreAcceso;
	}

	/**
	 * @param nombreAcceso the nombreAcceso to set
	 */
	public void setNombreAcceso(String nombreAcceso) {
		this.nombreAcceso = nombreAcceso;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	
}
