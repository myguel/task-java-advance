package pe.edu.cibertec.core.dao;

import java.util.List;

import pe.edu.cibertec.core.domain.Profesor;

public interface ProfesorDAO extends GenericDAO<Profesor> {

	List<Profesor> getProfesors();
	
}
