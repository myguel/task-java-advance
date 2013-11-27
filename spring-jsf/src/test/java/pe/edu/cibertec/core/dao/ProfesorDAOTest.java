package pe.edu.cibertec.core.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import pe.edu.cibertec.common.AbstractJunitTest;
import pe.edu.cibertec.core.domain.Profesor;

public class ProfesorDAOTest  extends AbstractJunitTest{
	@Autowired
	private ProfesorDAO profesorDAO;
	@Ignore
	@Test
	@Rollback(false)
	public void save(){
		Profesor  t=new Profesor();
		t.setApellido("LIBERATO");
		t.setCorreo("liberato.myguel@gmail.com");
		t.setDireccion("Liince");
		t.setDni("23456789");
		t.setEstado(true);
		t.setNombre("Miguel");
		t.setTelefono("123456789");
		profesorDAO.save(t);
	}

	 @Test
	public void getProfesor(){
		List<Profesor>list=profesorDAO.getProfesors();
		for (Profesor profesor : list) {
			System.out.println(profesor.getNombre());
			System.out.println(profesor.getProfesorId());
			
		}
	}
}
