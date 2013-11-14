package pe.edu.cibertec.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.edu.cibertec.common.Constantes;
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
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programa_id")
	private Programa programa;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
	private Profesor profesor;
	@Column(name="duracion")
	private Integer duracion;
	@Column(name="fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	@Column(name="precio")
	private BigDecimal precio;
	@Column(name="estado")
	private Boolean estado;
	
	public Laboratorio() {
	}
	public Laboratorio(Long id) {
		this.laboratorioId=id;
	}
	
	public Laboratorio(String nombre, Integer duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}
	
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
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		SimpleDateFormat dateFormat=new SimpleDateFormat(Constantes.DATE_FORMAT);
		StringBuilder builder = new StringBuilder();
		builder.append("Laboratorio [laboratorioId=");
		builder.append(laboratorioId);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", programa=");
		builder.append(programa.getProgramaId());
		builder.append(", profesor=");
		builder.append(profesor.getProfesorId());
		builder.append(", duracion=");
		builder.append(duracion);
		builder.append(", fecha=");
		builder.append(dateFormat.format(fecha));
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", estado=");
		builder.append(estado);
		builder.append("]");
		return builder.toString();
	}
	
	
}
