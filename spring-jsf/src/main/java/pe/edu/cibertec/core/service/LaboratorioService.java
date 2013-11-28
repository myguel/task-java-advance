package pe.edu.cibertec.core.service;

import java.util.List;

import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.domain.Programa;
import pe.edu.cibertec.exception.BusinessException;

public interface LaboratorioService extends GenericService<Laboratorio>{

	public List<Profesor> getProfesors();
	public List<Programa> getProgramas();
	public List<Laboratorio> getAll(Filtro filtro);
}
