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
import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Profesor;
import pe.edu.cibertec.core.domain.Programa;

public class LaboratorioServiceTest extends AbstractJunitTest {

    private static final Logger logger = LoggerFactory.getLogger(LaboratorioServiceTest.class);
    @Autowired
    private LaboratorioService laboratorioService;

    @Test 
    @Ignore
    public void getAll() {
        List<Laboratorio> laboratorios = laboratorioService.getAll();
		Assert.assertTrue(laboratorios.size()>0);
        for (Laboratorio laboratorio : laboratorios) {
            logger.info("## DATA: " + laboratorio.getNombre());
        }
    }
    
   @Ignore
    @Test
    @Rollback(false)
    public void save(){
    	Laboratorio laboratorio=new Laboratorio();
    	laboratorio.setDuracion(2);
    	laboratorio.setEstado(false);
    	laboratorio.setFecha(new Date());
    	laboratorio.setNombre("EXAMEN FINAL");
    	laboratorio.setPrecio(new BigDecimal(451.5));
    	laboratorio.setProfesor(new Profesor(1));
    	laboratorio.setPrograma(new Programa(1));
    	laboratorioService.save(laboratorio);
    }
    
    
    @Test
    public void findByParameter() {
    	Filtro filtro=new Filtro();
    	filtro.setEstado(true);;
//    	filtro.setFecha(TypesUtil.getDateFromString("27/11/2013"));
//    	filtro.setNombre("L");
//    	filtro.setProfesor(3);
//    	filtro.setPrograma(3);
    	List<Laboratorio> laboratorios=laboratorioService.findByParameters(filtro);
    	for (Laboratorio laboratorio : laboratorios) {
		System.out.println("###############: "+laboratorio.getProfesor().getNombre());
		System.out.println("###############: "+laboratorio.getPrograma().getNombre());
		
		}
    }
}
