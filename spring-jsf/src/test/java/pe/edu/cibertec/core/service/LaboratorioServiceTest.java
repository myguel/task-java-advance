package pe.edu.cibertec.core.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import pe.edu.cibertec.common.AbstractJunitTest;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.domain.Programa;

public class LaboratorioServiceTest extends AbstractJunitTest {

    private static final Logger logger = LoggerFactory.getLogger(LaboratorioServiceTest.class);
    @Autowired
    private LaboratorioService laboratorioService;

    @Test    
    public void getAll() {
        List<Laboratorio> laboratorios = laboratorioService.getAll();
		Assert.assertTrue(laboratorios.size()>0);
        for (Laboratorio laboratorio : laboratorios) {
            logger.info("## DATA: " + laboratorio.getNombre());
        }
    }
    
   
    @Test
    @Ignore
    @Rollback(false)
    public void save(){
    	Laboratorio laboratorio=new Laboratorio();
    	laboratorio.setDuracion(4);
    	laboratorio.setEstado(true);
    	laboratorio.setFecha(new Date());
    	laboratorio.setNombre("LPIII");
    	laboratorio.setPrecio(new BigDecimal(451.5));
    	laboratorio.setProfesor(new Profesor(1));
    	laboratorio.setPrograma(new Programa(1));
    	laboratorioService.save(laboratorio);
    }
    
}
