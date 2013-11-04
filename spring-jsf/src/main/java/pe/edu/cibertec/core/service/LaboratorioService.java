package pe.edu.cibertec.core.service;

import java.util.List;

import pe.edu.cibertec.core.domain.Laboratorio;

public interface LaboratorioService {

	void save(Laboratorio laboratorio);
	void update(Laboratorio laboratorio);
	Laboratorio get(Laboratorio laboratorio);
	List<Laboratorio>  getAll();
	void delete(Laboratorio laboratorio);
}
