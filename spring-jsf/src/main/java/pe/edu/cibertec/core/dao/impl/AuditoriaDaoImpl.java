/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.core.dao.impl;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.core.dao.AuditoriaDAO;
import pe.edu.cibertec.core.domain.*;

/**
 *
 * @author jpadilla
 */
@Repository("auditoriaDao")
public class AuditoriaDaoImpl implements AuditoriaDAO{
     @PersistenceContext
    private EntityManager em;

    public void save(Auditoria t) {
        em.persist(t);
    }

    public void update(Auditoria t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Auditoria get(Auditoria t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Auditoria> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Auditoria t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
