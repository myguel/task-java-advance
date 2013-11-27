package pe.edu.cibertec.core.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import pe.edu.cibertec.common.AbstractJunitTest;
import pe.edu.cibertec.core.domain.Profesor;

public class ProfesorDAOTest  extends AbstractJunitTest{
	@Autowired
	private ProfesorDAO profesorDAO;
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

}
