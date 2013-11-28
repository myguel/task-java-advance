package pe.edu.cibertec.common;

import java.util.Date;

public class Filtro {

	private String nombre;
	private Integer profesor;
	private Integer programa;
	private Integer estado;
	private Date fecha;
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
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
