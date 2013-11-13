/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.audit.service;

import org.springframework.stereotype.Service;

import pe.edu.cibertec.core.domain.Auditoria;
import pe.edu.cibertec.core.service.GenericService;

/**
 *
 * @author jpadilla
 */
@Service("auditoriaService")
public interface AuditoriaService extends GenericService<Auditoria> {
    
}
