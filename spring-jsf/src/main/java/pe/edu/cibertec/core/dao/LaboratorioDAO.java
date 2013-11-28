package pe.edu.cibertec.core.dao;

import java.util.List;

import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.core.domain.Laboratorio;

public interface LaboratorioDAO extends GenericDAO<Laboratorio>{

	List<Laboratorio> findByParameters(Filtro filtro);

}
