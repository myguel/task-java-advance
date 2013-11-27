package pe.edu.cibertec.core.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import pe.edu.cibertec.common.AbstractJunitTest;
import pe.edu.cibertec.core.domain.Programa;

public class ProgramaDAOTest extends AbstractJunitTest {

	@Autowired
	private ProgramaDAO programaDAO;

	@Test
	@Ignore
	@Rollback(false)
	public void save() {
		Programa programa = new Programa();
		programa.setEstado(true);
		programa.setNombre("SWII");
		programaDAO.save(programa);

	}

	@Test
	public void getProfesor() {
		List<Programa> list = programaDAO.getProgramas();
		for (Programa programa : list) {
			System.out.println(programa.getNombre());
			System.out.println(programa.getProgramaId());

		}
	}
}
