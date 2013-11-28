package pe.edu.cibertec.core.dao;

import java.util.List;

import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Programa;

public interface ProgramaDAO extends GenericDAO<Programa>{

	List<Programa> getProgramas();

}
