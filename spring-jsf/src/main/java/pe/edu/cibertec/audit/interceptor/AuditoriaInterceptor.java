/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.audit.interceptor;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.audit.domain.Auditoria;
import pe.edu.cibertec.audit.service.AuditoriaService;
import pe.edu.cibertec.core.domain.Laboratorio;

/**
 *
 * @author jpadilla
 */
@Aspect
@Component("auditoriaInterceptor")
public class AuditoriaInterceptor {

    @Autowired
    private AuditoriaService serviceAuditoriaService;

    public void beforeDeleteLaboratorioInterceptor(JoinPoint joinPoint) {
        Laboratorio laboratorio = (Laboratorio) joinPoint.getArgs()[0];
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setValor("Eliminado: " + laboratorio.toString());
        serviceAuditoriaService.save(auditoria);
    }

    @After("execution(* pe.edu.cibertec.core.dao.impl.LaboratorioDAOImpl.delete(pe.edu.cibertec.core.domain.Laboratorio)) && args(laboratorio)")
    public void afterDeleteLaboratorioInterceptor(Laboratorio laboratorio) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setValor("Eliminado: " + laboratorio.toString());
        serviceAuditoriaService.save(auditoria);
    }

    public void beforeSaveAutorInterceptor(JoinPoint joinPoint) {
        Laboratorio laboratorio = (Laboratorio) joinPoint.getArgs()[0];
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setValor("Insertado: " + laboratorio.toString());
        serviceAuditoriaService.save(auditoria);
    }

    @After("execution(* pe.edu.cibertec.core.dao.impl.LaboratorioDAOImpl.save(pe.edu.cibertec.core.domain.Laboratorio)) && args(laboratorio)")
    public void afterSaveLaboratorioInterceptor(Laboratorio laboratorio) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setValor("Insertado: " + laboratorio.toString());
        serviceAuditoriaService.save(auditoria);
    }
}
