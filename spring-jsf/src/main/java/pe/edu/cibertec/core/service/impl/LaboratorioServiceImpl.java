package pe.edu.cibertec.core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.core.dao.LaboratorioDAO;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.service.LaboratorioService;
@Service
@Transactional
public class LaboratorioServiceImpl implements LaboratorioService {

	private static final Logger logger=LoggerFactory.getLogger(LaboratorioServiceImpl.class);
	@Autowired
	private LaboratorioDAO laboratorioDAO;
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(Laboratorio laboratorio) {
		logger.info("save");
		laboratorioDAO.save(laboratorio);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Laboratorio laboratorio) {
		laboratorioDAO.update(laboratorio);
		
	}

	@Override
	public Laboratorio get(Laboratorio laboratorio) {		
		return laboratorioDAO.get(laboratorio);
	}

	@Override
	public List<Laboratorio> getAll() {
		return laboratorioDAO.getAll();
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Laboratorio laboratorio) {
		laboratorioDAO.delete(laboratorio);
		
	}

}
