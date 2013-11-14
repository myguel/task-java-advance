/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.audit.interceptor;

import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.audit.domain.Auditoria;
import pe.edu.cibertec.audit.service.AuditoriaService;

/**
 *
 * @author jpadilla
 */
@Aspect
@Component("auditoriaInterceptor")
public class AuditoriaInterceptor {
	private static final Logger logger=LoggerFactory.getLogger(AuditoriaInterceptor.class);
			

    @Autowired
    private AuditoriaService auditoriaService;

    
    @AfterReturning("execution(* pe.edu.cibertec.core.service.impl.*.*(..))")
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
}
