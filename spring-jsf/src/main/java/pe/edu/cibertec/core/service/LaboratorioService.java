package pe.edu.cibertec.core.service;

import java.util.List;

import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.domain.Programa;

public interface LaboratorioService extends GenericService<Laboratorio>{

	List<Profesor> getProfesors();
	List<Programa> getProgramas();
}
