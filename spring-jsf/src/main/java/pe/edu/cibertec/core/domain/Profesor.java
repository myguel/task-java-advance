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
@Table(name="profesor")
public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="profesor_id")	
	private Integer profesorId;
	@Column(name="apellidos")
	private String apellido;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion")
	private String direccion;
	@Column(name="correo")
	private String correo;
	@Column(name="telefono")
	private String telefono;
	@Column(name="dni")
	private String dni;
	@Column(name="estado")
	private Boolean estado;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")
	private List<Laboratorio> laboratorios;
	
	public Profesor() {
		
	}
	public Integer getProfesorId() {
		return profesorId;
	}
	public void setProfesorId(Integer profesorId) {
		this.profesorId = profesorId;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}
	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}
	

}
