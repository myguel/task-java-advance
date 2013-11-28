package pe.edu.cibertec.core.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import pe.edu.cibertec.common.FacesContextUtil;
import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.domain.Programa;
import pe.edu.cibertec.core.service.LaboratorioService;
import pe.edu.cibertec.core.service.ProfesorService;
import pe.edu.cibertec.core.service.ProgramaService;

@ManagedBean(name = "laboratorioController")
@ViewScoped
public class LaboratorioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(LaboratorioController.class);
	
	@ManagedProperty (value = "#{laboratorioService}")
	LaboratorioService laboratorioService;
	
	@ManagedProperty (value = "#{profesorService}")
	ProfesorService profesorService;
	
	@ManagedProperty (value = "#{programaService}")
	ProgramaService programaService;
	
	Laboratorio laboratorio;
	Filtro filtro;

	List<Laboratorio> laboratorios;
	List<Profesor> profesores;
	List<Profesor> profesoresBusqueda;
	
	List<Programa> programas;
	List<Programa> programasBusqueda;

	public LaboratorioController() {
		
	}

	@PostConstruct
	void inicio() {
		laboratorio = new Laboratorio();
		filtro = new Filtro();
		profesores = profesorService.getProfesors();
		programas = programaService.getProgramas();
		laboratorios = laboratorioService.getAll();
		
	}
	
	
	public void buscarLaboratorios() {
		laboratorios = laboratorioService.findByParameters(filtro);
	}

	public void limpiarLaboratorios() {
		filtro = new Filtro();
	}

	public void editarLaboratorio() {

	}

	public void eliminarLaboratorios() {
		laboratorioService.delete(laboratorio);
	}

	public void nuevoLaboratorio() {
		laboratorio = new Laboratorio();
	}
	
	public void guardarLaboratorio() {
		try {
			laboratorioService.save(laboratorio);
			FacesContextUtil.mensajeGuardar();
		} catch (Exception e) {
			FacesContextUtil.mensajeError();
			logger.error(e.getMessage());
		}
	}
	
	public void actualizarLaboratorio() {

	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

	public LaboratorioService getLaboratorioService() {
		return laboratorioService;
	}

	public void setLaboratorioService(LaboratorioService laboratorioService) {
		this.laboratorioService = laboratorioService;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public ProfesorService getProfesorService() {
		return profesorService;
	}

	public void setProfesorService(ProfesorService profesorService) {
		this.profesorService = profesorService;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public List<Profesor> getProfesoresBusqueda() {
		return profesoresBusqueda;
	}

	public void setProfesoresBusqueda(List<Profesor> profesoresBusqueda) {
		this.profesoresBusqueda = profesoresBusqueda;
	}

	public List<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

	public List<Programa> getProgramasBusqueda() {
		return programasBusqueda;
	}

	public void setProgramasBusqueda(List<Programa> programasBusqueda) {
		this.programasBusqueda = programasBusqueda;
	}

	public ProgramaService getProgramaService() {
		return programaService;
	}

	public void setProgramaService(ProgramaService programaService) {
		this.programaService = programaService;
	}

	public Filtro getFiltro() {
		return filtro;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

}
