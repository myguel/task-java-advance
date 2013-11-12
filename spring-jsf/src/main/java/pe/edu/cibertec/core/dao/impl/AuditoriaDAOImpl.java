/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.cibertec.core.dao.AuditoriaDAO;
import pe.edu.cibertec.core.domain.Auditoria;

/**
 *
 * @author jpadilla
 */
@Repository
public class AuditoriaDAOImpl implements AuditoriaDAO {

    @PersistenceContext
    private EntityManager em;

	@Override
	public void save(Auditoria t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Auditoria t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Auditoria get(Auditoria t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auditoria> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Auditoria t) {
		// TODO Auto-generated method stub
		
	}

}
