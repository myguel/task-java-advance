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
@Service
public class AuditoriaServiceImpl implements AuditoriaService {

	@Autowired
	private AuditoriaDAO auditoriaDAO;

	public void save(Auditoria t) {
		auditoriaDAO.save(t);
	}

	public void update(Auditoria t) {
		auditoriaDAO.update(t);

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
		auditoriaDAO.delete(t.getAuditoriaId());

	}
}
