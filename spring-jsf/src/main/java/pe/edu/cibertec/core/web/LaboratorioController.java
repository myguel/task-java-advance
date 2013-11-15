package pe.edu.cibertec.core.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.service.LaboratorioService;

@ManagedBean(name = "laboratorioController")
@ViewScoped
public class LaboratorioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty (value = "#{laboratorioService}")
	LaboratorioService laboratorioService;
	Laboratorio laboratorio;

	List<Laboratorio> laboratorios;

	public LaboratorioController() {
		
	}

	@PostConstruct
	void inicio() {
		laboratorio = new Laboratorio();
		laboratorios = laboratorioService.getAll();
	}
	
	public void buscarLaboratorios() {

	}

	public void limpiarLaboratorios() {

	}

	public void editarLaboratorio() {

	}

	public void eliminarLaboratorios() {

	}

	public void nuevoLaboratorio() {

	}
	
	public void guardarLaboratorio() {

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

}
