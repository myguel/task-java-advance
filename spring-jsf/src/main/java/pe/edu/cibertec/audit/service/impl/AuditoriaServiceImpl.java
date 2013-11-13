/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.audit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.audit.dao.AuditoriaDAO;
import pe.edu.cibertec.audit.domain.Auditoria;
import pe.edu.cibertec.audit.service.AuditoriaService;

/**
 *
 * @author jpadilla
 */
@Service("auditoriaService")
public class AuditoriaServiceImpl implements AuditoriaService {

     @Autowired
    AuditoriaDAO dao;
	
	public void save(Auditoria t) {
		// TODO Auto-generated method stub
//		 dao.insert(auditoria);
                dao.save(t);
	}

	
	public void update(Auditoria t) {
		// TODO Auto-generated method stub
		
	}

	
	public Auditoria get(Auditoria t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Auditoria> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void delete(Auditoria t) {
		// TODO Auto-generated method stub
		
	}
}
