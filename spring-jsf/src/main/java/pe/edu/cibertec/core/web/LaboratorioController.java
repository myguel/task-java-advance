package pe.edu.cibertec.core.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.cibertec.common.FacesContextUtil;
import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.common.TypesUtil;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.domain.Programa;
import pe.edu.cibertec.core.service.LaboratorioService;
import pe.edu.cibertec.core.service.ProfesorService;
import pe.edu.cibertec.core.service.ProgramaService;
import pe.edu.cibertec.exception.BusinessException;

@ManagedBean(name = "laboratorioController")
@ViewScoped
public class LaboratorioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(LaboratorioController.class);
	
	@ManagedProperty (value = "#{laboratorioService}")
	@Autowired
	private LaboratorioService laboratorioService;
	
	@ManagedProperty (value = "#{profesorService}")
	private ProfesorService profesorService;
	
	@ManagedProperty (value = "#{programaService}")
	private ProgramaService programaService;
	
	private Laboratorio laboratorio;
	private Filtro filtro;

	private List<Laboratorio> laboratorios;
	private List<Profesor> profesores;
	private List<Profesor> profesoresBusqueda;
	
	private List<Programa> programas;
	private List<Programa> programasBusqueda;

	public LaboratorioController() {
		
	}

	@PostConstruct
	void inicio() {
		laboratorio = new Laboratorio();
		filtro = new Filtro();
		profesores = profesorService.getProfesors();
		programas = programaService.getProgramas();
		laboratorios = laboratorioService.findByParameters(filtro);
		
	}
	
	
	public void buscarLaboratorios() {
		System.out.println(filtro.toString());
		if(filtro.getEstado().equals("A")){
			filtro.setEnabled(true);
		}else if(filtro.getEstado().equals("I")){
			filtro.setEnabled(false);
		}else{
			filtro.setEnabled(null);
		}
		if(filtro.getProfesor()!=null&&filtro.getProfesor()>0){
			filtro.setProfesor(filtro.getProfesor());
		}else{
			filtro.setProfesor(null);
		}
		if(filtro.getPrograma()!=null&&filtro.getPrograma()>0){
			filtro.setPrograma(filtro.getPrograma());
		}else{
			filtro.setPrograma(null);
		}
		if(filtro.getNombre()!=null&&filtro.getNombre().trim()!=""){
			filtro.setNombre(filtro.getNombre());
		}else{
			filtro.setNombre(null);
		}
		if(filtro.getFecha()!=null){
//			filtro.setFecha(TypesUtil.getDateToString(filtro.getFecha().toString()));
			filtro.setFecha(filtro.getFecha());
		}else{
			filtro.setFecha(null);
		}
		System.out.println(filtro.toString());
		laboratorios = laboratorioService.findByParameters(filtro);


	}

	public void limpiarLaboratorios() {
		filtro = new Filtro();
	}

	public void editarLaboratorio() {
			try {
				laboratorioService.update(laboratorio);
			} catch (BusinessException e) {
				FacesContextUtil.error(e.getMessage());
			}
	}

	public void eliminarLaboratorios() {
		try {
			laboratorioService.delete(laboratorio);	
			FacesContextUtil.mensajeEliminar();
		} catch (BusinessException e) {
			FacesContextUtil.error(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.mensajeError();
		}
	}

	public void nuevoLaboratorio() {
		laboratorio = new Laboratorio();
	}
	
	public void guardarLaboratorio() {
		try {
			if(laboratorio.getLaboratorioId()!=null){
				laboratorioService.update(laboratorio);
				FacesContextUtil.mensajeActualizar();
			}else{
				laboratorioService.save(laboratorio);				
				FacesContextUtil.mensajeGuardar();
			}

		} catch (BusinessException e) {
			FacesContextUtil.error(e.getMessage());
			logger.error("BUSNESS: "+e.getMessage());
		}catch (Exception e) {
		logger.info("ERROR: "+e.getMessage());
		FacesContextUtil.mensajeError();
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
