package pe.edu.cibertec.core.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import pe.edu.cibertec.common.AbstractJunitTest;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.domain.Programa;

public class LaboratorioDAOTest extends AbstractJunitTest {

    private static final Logger logger = LoggerFactory.getLogger(LaboratorioDAOTest.class);
    @Autowired
    private LaboratorioDAO laboratorioDAO;

    @Test    
    public void getAll() {
        List<Laboratorio> laboratorios = laboratorioDAO.getAll();
//		Assert.assertEquals(laboratorios.size(), 3);
        for (Laboratorio laboratorio : laboratorios) {
            logger.info("Data: " + laboratorio.getNombre());
        }
    }
    @Test
    @Rollback(false)
    public void save(){
    	Laboratorio laboratorio=new Laboratorio();
    	laboratorio.setDuracion(4);
    	laboratorio.setEstado(true);
    	laboratorio.setFecha(new Date());
    	laboratorio.setNombre("LP");
    	laboratorio.setPrecio(new BigDecimal(451.5));
    	laboratorio.setProfesor(new Profesor(1));
    	laboratorio.setPrograma(new Programa(1));
    	laboratorioDAO.save(laboratorio);
    }
    
}
