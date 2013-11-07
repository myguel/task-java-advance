package pe.edu.cibertec.core.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pe.edu.cibertec.core.domain.Laboratorio;

@ManagedBean(name="laboratorioController")
@RequestScoped
public class LaboratorioController {

	
	Laboratorio laboratorio;

	List<Laboratorio> laboratorios;

	public LaboratorioController() {

	}

	@PostConstruct
	public void inicio() {
		listarLaboratorios(laboratorios);
	}
	

	private void listarLaboratorios(List<Laboratorio> laboratorios2) {
		laboratorios = new ArrayList<Laboratorio>();
		laboratorios.add(new Laboratorio("laboratorio", 10));
		
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

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}
}
