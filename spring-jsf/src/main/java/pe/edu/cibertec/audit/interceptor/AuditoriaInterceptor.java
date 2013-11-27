/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.audit.interceptor;

import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.audit.domain.Auditoria;
import pe.edu.cibertec.audit.service.AuditoriaService;
import pe.edu.cibertec.exception.BusinessException;

/**
 *
 * @author jpadilla
 */
@Aspect
@Component
public class AuditoriaInterceptor {
	private static final Logger logger=LoggerFactory.getLogger(AuditoriaInterceptor.class);
			

    @Autowired
    private AuditoriaService auditoriaService;

    
    @AfterReturning("execution( void pe.edu.cibertec.core.service.impl.LaboratorioServiceImpl.*(..))")
    public void save(JoinPoint joinPoint){
    	String name = joinPoint.getSignature().toShortString();
    	logger.info(name);
    	Object object = joinPoint.getArgs()[0];
    	logger.info(object.toString());
    	Auditoria auditoria=new Auditoria();
    	auditoria.setFecha(Calendar.getInstance().getTime());
    	auditoria.setValor(object.toString());
    	auditoriaService.save(auditoria);;
    }
    
    @Before("execution( void pe.edu.cibertec.core.service.impl.LaboratorioServiceImpl.*(..))")
	public void saveAntes(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("ANTES:.:::.::" + method);
		Object object = joinPoint.getArgs()[0];
		Auditoria auditoria = new Auditoria();
		auditoria.setFecha(Calendar.getInstance().getTime());
		logger.info(object.toString());
		auditoria.setValor("ANTES: "+object.toString());
		auditoriaService.save(auditoria);
	}
	@After("execution( void pe.edu.cibertec.core.service.impl.LaboratorioServiceImpl.*(..))")
	public void saveDespues(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("DESPUES:.:::.::" + method);
		Object object = joinPoint.getArgs()[0];
		Auditoria auditoria = new Auditoria();
		auditoria.setFecha(Calendar.getInstance().getTime());
		logger.info(object.toString());
		auditoria.setValor("DESPUES: "+object.toString());
		auditoriaService.save(auditoria);
	}
	
	
	@Before("execution( * pe.edu.cibertec.core.service.impl.LaboratorioServiceImpl.get*(..))")
	public void getInService(JoinPoint joinPoint){
		String method=joinPoint.getSignature().getName();
		Auditoria audit=new Auditoria();
		audit.setFecha(Calendar.getInstance().getTime());
		audit.setValor("SEE : "+method);
		auditoriaService.save(audit);
	}
	
	@Before("execution( * pe.edu.cibertec.core.service.impl.LaboratorioServiceImpl.getBy*(..))")
	public void getGetByService(JoinPoint joinPoint){
		String method=joinPoint.getSignature().getName();
		Auditoria audit=new Auditoria();
		audit.setFecha(Calendar.getInstance().getTime());
		audit.setValor("SEE : "+method);
		auditoriaService.save(audit);
	}
	
	@AfterThrowing(pointcut="execution( void pe.edu.cibertec.core.service.impl.LaboratorioServiceImpl.*(..))",
			throwing="e")	
	public void findWithThows(JoinPoint joinPoint,BusinessException  e){
		String method=joinPoint.getSignature().getName();
		System.out.println(e);
		System.out.println(joinPoint.getArgs());
		Auditoria audit=new Auditoria();
		audit.setFecha(Calendar.getInstance().getTime());
		audit.setValor("WITH THROWS : "+method+":MENSAJE: "+e.getErrorCode());
		auditoriaService.save(audit);
	}
    
}
