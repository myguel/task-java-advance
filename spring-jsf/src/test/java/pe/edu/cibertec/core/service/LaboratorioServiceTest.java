package pe.edu.cibertec.core.service;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.cibertec.common.AbstractJunitTest;
import pe.edu.cibertec.core.domain.Laboratorio;

public class LaboratorioServiceTest extends AbstractJunitTest {

    private static final Logger logger = LoggerFactory.getLogger(LaboratorioServiceTest.class);
    @Autowired
    private LaboratorioService laboratorioService;

    @Test
    public void getAll() {
        List<Laboratorio> laboratorios = laboratorioService.getAll();
//		Assert.assertEquals(laboratorios.size(), 3);
        for (Laboratorio laboratorio : laboratorios) {
            logger.info("Data: " + laboratorio.getNombre());
        }
    }
}
