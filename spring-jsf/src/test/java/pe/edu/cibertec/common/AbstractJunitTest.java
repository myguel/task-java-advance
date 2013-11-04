package pe.edu.cibertec.common;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:pe/edu/cibertec/app-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
@Ignore
public class AbstractJunitTest {
	private static final Logger logger=LoggerFactory.getLogger(AbstractJunitTest.class);
	@Before
	public void start() {
		logger.info(":::INFORMACION DE SALIDA:::");
	}

	@After
	public void end() {
		logger.info(":::FIN DE INFORMACION:::");
	}
	@Test
	public void  isTest(){
		Assert.assertTrue(true);
	}
}
