package pe.edu.cibertec.core.service.impl;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.core.dao.LaboratorioDAO;
import pe.edu.cibertec.core.dao.ProfesorDAO;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.service.LaboratorioService;
import pe.edu.cibertec.core.service.ProfesorService;
@Service("profesorService")
@Transactional
public class ProfesorServiceImpl implements ProfesorService {

	private static final Logger logger=LoggerFactory.getLogger(ProfesorServiceImpl.class);
	@Autowired
	private ProfesorDAO profesorDAO;
	

	@Override
	public List<Profesor> getProfesors() {
		return profesorDAO.getProfesors();
	}

	
}
