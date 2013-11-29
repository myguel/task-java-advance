package pe.edu.cibertec.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author myguel
 *
 */
public class Filtro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Integer profesor;
	private Integer programa;
//	private Boolean estado;
	private String estado;
	private Boolean enabled;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Filtro [");
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		if (profesor != null) {
			builder.append("profesor=");
			builder.append(profesor);
			builder.append(", ");
		}
		if (programa != null) {
			builder.append("programa=");
			builder.append(programa);
			builder.append(", ");
		}
		if (estado != null) {
			builder.append("estado=");
			builder.append(estado);
			builder.append(", ");
		}
		if (enabled != null) {
			builder.append("enabled=");
			builder.append(enabled);
			builder.append(", ");
		}
		if (fecha != null) {
			builder.append("fecha=");
			builder.append(fecha);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
