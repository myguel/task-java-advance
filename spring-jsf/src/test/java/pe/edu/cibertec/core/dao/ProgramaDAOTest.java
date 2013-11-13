package pe.edu.cibertec.core.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import pe.edu.cibertec.common.AbstractJunitTest;
import pe.edu.cibertec.core.domain.Programa;

public class ProgramaDAOTest extends AbstractJunitTest{

	@Autowired
	private ProgramaDAO programaDAO;
	@Test
	@Rollback(false)
	public void save(){
		Programa programa=new Programa();
		programa.setEstado(true);
		programa.setNombre("SWII");
		programaDAO.save(programa);
		
	}
}
