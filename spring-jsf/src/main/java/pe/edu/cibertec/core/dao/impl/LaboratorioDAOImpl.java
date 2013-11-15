package pe.edu.cibertec.core.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.core.dao.LaboratorioDAO;
import pe.edu.cibertec.core.domain.Laboratorio;

@Repository("laboratorioDAO")
public class LaboratorioDAOImpl extends AbstractDAOImpl<Laboratorio> implements LaboratorioDAO {
	private static final Logger logger=LoggerFactory.getLogger(LaboratorioDAOImpl.class);
	


}
