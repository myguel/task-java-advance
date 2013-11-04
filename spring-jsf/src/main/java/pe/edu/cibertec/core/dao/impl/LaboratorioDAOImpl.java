package pe.edu.cibertec.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.core.dao.LaboratorioDAO;
import pe.edu.cibertec.core.domain.Laboratorio;
@Repository
public class LaboratorioDAOImpl  implements LaboratorioDAO {
	private static final Logger logger=LoggerFactory.getLogger(LaboratorioDAOImpl.class);
	@PersistenceContext
    private EntityManager em;
	@Override
	public void save(Laboratorio laboratorio) {
		logger.info("SAVE");

	}

	@Override
	public void update(Laboratorio laboratorio) {
		logger.info("UPDATE");

	}

	@Override
	public Laboratorio get(Laboratorio laboratorio) {
		logger.info("GET");
		return null;
	}

	@Override
	public List<Laboratorio> getAll() {
		logger.info("GET ALL");
		return null;
	}

	@Override
	public void delete(Laboratorio laboratorio) {
		logger.info("DELETE");

	}

}
