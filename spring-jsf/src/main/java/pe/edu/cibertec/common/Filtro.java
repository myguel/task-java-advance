package pe.edu.cibertec.common;

import java.io.Serializable;
import java.util.Date;

public class Filtro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Integer profesor;
	private Integer programa;
	private Boolean estado;
	private Date fecha;

	public Filtro() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getProfesor() {
		return profesor;
	}

	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}

	public Integer getPrograma() {
		return programa;
	}

	public void setPrograma(Integer programa) {
		this.programa = programa;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

	
}
