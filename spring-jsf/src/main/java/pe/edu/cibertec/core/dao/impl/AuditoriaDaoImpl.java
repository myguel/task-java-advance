/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.core.dao.impl;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.core.dao.AuditoriaDAO;
import pe.edu.cibertec.core.domain.*;

/**
 *
 * @author jpadilla
 */
@Repository("auditoriaDao")
public class AuditoriaDaoImpl implements AuditoriaDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Auditoria> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Auditoria getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    public void insert(Auditoria auditoria) {
        em.persist(auditoria);
    }

    public void update(Auditoria auditoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Auditoria auditoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
