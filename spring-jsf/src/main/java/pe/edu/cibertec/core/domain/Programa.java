package pe.edu.cibertec.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author mliberato
 *
 */
@Entity
@Table(name="programa")
public class Programa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="programa_id")
	private Integer programaId;
	@Column(name="nombre")
	private String nombre;
	@Column(name="estado")
	private Boolean estado;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "programa")
	private List<Laboratorio> laboratorios;
	public Programa() {
		
	}
	public Integer getProgramaId() {
		return programaId;
	}
	public void setProgramaId(Integer programaId) {
		this.programaId = programaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	/**
	 * 
	 */
	

}
