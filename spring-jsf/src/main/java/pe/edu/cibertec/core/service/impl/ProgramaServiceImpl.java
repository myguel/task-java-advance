package pe.edu.cibertec.core.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.core.dao.ProgramaDAO;
import pe.edu.cibertec.core.domain.Programa;
import pe.edu.cibertec.core.service.ProgramaService;
@Service("programaService")
@Transactional
public class ProgramaServiceImpl implements ProgramaService {

	private static final Logger logger=LoggerFactory.getLogger(ProgramaServiceImpl.class);
	@Autowired
	private ProgramaDAO programaDAO;
	

	@Override
	public List<Programa> getProgramas() {
		return programaDAO.getProgramas();
	}

	
}
