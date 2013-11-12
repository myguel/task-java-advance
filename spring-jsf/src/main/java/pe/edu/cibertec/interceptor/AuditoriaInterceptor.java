/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.interceptor;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.core.domain.Auditoria;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.service.AuditoriaService;

/**
 *
 * @author jpadilla
 */
@Aspect
@Component("auditoriaInterceptor")
public class AuditoriaInterceptor {

    @Autowired
    AuditoriaService service;

    public void beforeDeleteLaboratorioInterceptor(JoinPoint joinPoint) {
        Laboratorio laboratorio = (Laboratorio) joinPoint.getArgs()[0];
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setValor("Eliminado: " + laboratorio.toString());
        service.save(auditoria);
    }

    @After("execution(* pe.edu.cibertec.core.dao.impl.LaboratorioDaoImpl.delete(pe.edu.cibertec.core.domain.Laboratorio)) && args(laboratorio)")
    public void afterDeleteLaboratorioInterceptor(Laboratorio laboratorio) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setValor("Eliminado: " + laboratorio.toString());
        service.save(auditoria);
    }

    public void beforeSaveAutorInterceptor(JoinPoint joinPoint) {
        Laboratorio laboratorio = (Laboratorio) joinPoint.getArgs()[0];
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setValor("Insertado: " + laboratorio.toString());
        service.save(auditoria);
    }

    @After("execution(* pe.edu.cibertec.core.dao.impl.LaboratorioDaoImpl.save(pe.edu.cibertec.core.domain.Laboratorio)) && args(laboratorio)")
    public void afterSaveLaboratorioInterceptor(Laboratorio laboratorio) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setValor("Insertado: " + laboratorio.toString());
        service.save(auditoria);
    }
}
