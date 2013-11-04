package pe.edu.cibertec.core.dao;

import java.util.List;

import pe.edu.cibertec.core.domain.Laboratorio;

public interface LaboratorioDAO {

	void save(Laboratorio laboratorio);
	void update(Laboratorio laboratorio);
	Laboratorio get(Laboratorio laboratorio);
	List<Laboratorio>  getAll();
	void delete(Laboratorio laboratorio);
}
