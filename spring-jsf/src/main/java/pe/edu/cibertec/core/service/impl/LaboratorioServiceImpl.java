package pe.edu.cibertec.core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.core.dao.LaboratorioDAO;
import pe.edu.cibertec.core.dao.ProfesorDAO;
import pe.edu.cibertec.core.dao.ProgramaDAO;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.domain.Programa;
import pe.edu.cibertec.core.service.LaboratorioService;
import pe.edu.cibertec.exception.BusinessException;
@Service
@Transactional
public class LaboratorioServiceImpl implements LaboratorioService {

	private static final Logger logger=LoggerFactory.getLogger(LaboratorioServiceImpl.class);
	
	@Autowired
	private LaboratorioDAO laboratorioDAO;
	@Autowired
	private ProfesorDAO profesorDAO;
	@Autowired
	private ProgramaDAO programaDAO;
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=BusinessException.class)
	public void save(Laboratorio laboratorio)  throws BusinessException{
		logger.info("save");
		if(laboratorio.getLaboratorioId()!=null){
			throw new BusinessException(BusinessException.SEVERITY_CRITICAL, "Estas intentando Actualizar cuando debe Registar un Nuevo Laboratorio");
		}else{			
			laboratorioDAO.save(laboratorio);
		}
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=BusinessException.class)
	public void update(Laboratorio laboratorio) throws BusinessException {
		if(laboratorio.getLaboratorioId()!=null){
			laboratorioDAO.update(laboratorio);
		}else{			
			throw new BusinessException(BusinessException.SEVERITY_NORMAL, "Por favor verifica los datos..");
		}
		
	}

	@Override
	public Laboratorio getById(Laboratorio laboratorio) {		
		return laboratorioDAO.get(laboratorio);
	}

	@Override
	public List<Laboratorio> getAll() {
		return laboratorioDAO.getAll();
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=BusinessException.class)
	public void delete(Laboratorio laboratorio) {

		if(laboratorio.getLaboratorioId()!=null){
			laboratorioDAO.delete(laboratorio);
		}else{			
			throw new BusinessException(BusinessException.SEVERITY_NORMAL, "Selecione bien el registro a dar de baja.");
		}
		
	}
	
	@Override
	public List<Profesor> getProfesors()throws BusinessException {
		List<Profesor> profesors=profesorDAO.getProfesors();
		if(profesors.size()>0){
			return profesors;
		}else{
			throw new BusinessException(BusinessException.SEVERITY_LOW, "No existe Profesores Registrados");
		}
		 
	}
	
	@Override
	public List<Programa> getProgramas() throws BusinessException{
		List<Programa> programas = programaDAO.getProgramas();
		if(programas.size()>0){
			return programas;
		}else{
			throw new BusinessException(BusinessException.SEVERITY_LOW, "No existe Programas Registrados");
		}
		
	}

}
