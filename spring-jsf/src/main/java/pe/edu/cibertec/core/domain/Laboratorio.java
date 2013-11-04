package pe.edu.cibertec.core.domain;

import java.io.Serializable;
/**
 * 
 * @author mliberato
 *
 */
public class Laboratorio implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long laboratorioId;
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
