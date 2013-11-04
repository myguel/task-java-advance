package pe.edu.cibertec.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author mliberato
 *
 */
@Entity
@Table(name="laboratorio")
public class Laboratorio implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="laboratorio_id")
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	private Long laboratorioId;
	@Column(name="nombre")
	private String nombre;
	public Long getLaboratorioId() {
		return laboratorioId;
	}
	public void setLaboratorioId(Long laboratorioId) {
		this.laboratorioId = laboratorioId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
