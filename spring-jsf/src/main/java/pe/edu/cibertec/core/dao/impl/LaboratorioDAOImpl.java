package pe.edu.cibertec.core.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.common.Constantes;
import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.core.dao.LaboratorioDAO;
import pe.edu.cibertec.core.domain.Laboratorio;

@Repository("laboratorioDAO")
public class LaboratorioDAOImpl extends AbstractDAOImpl<Laboratorio> implements LaboratorioDAO {
	private static final Logger logger=LoggerFactory.getLogger(LaboratorioDAOImpl.class);

	@Override
	public List<Laboratorio> findByParameters(Filtro filtro) {
		logger.info("findByParameters");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 
		CriteriaQuery<Laboratorio> criteriaQuery = cb.createQuery(Laboratorio.class);
		Root<Laboratorio> c = criteriaQuery.from(Laboratorio.class);
//		ParameterExpression<Integer> p = cb.parameter(Integer.class);
		criteriaQuery.select(c);
		List<Predicate> criteria = new ArrayList<Predicate>();
		if (!filtro.getNombre().equals("")) {
	        ParameterExpression<String> para = cb.parameter(String.class, filtro.getNombre());
	        criteria.add(cb.equal(c.get("nombre"), para));
	    }
		
		if(!filtro.getPrograma().equals(Constantes.S_NO_SELECCIONADO)){
			 ParameterExpression<Integer> para = cb.parameter(Integer.class, String.valueOf(filtro.getPrograma()));
		     criteria.add(cb.equal(c.get("programa.programaId"), para));
		}
		
		if(!filtro.getProfesor().equals(Constantes.S_NO_SELECCIONADO)){
			 ParameterExpression<Integer> para = cb.parameter(Integer.class, String.valueOf(filtro.getProfesor()));
		     criteria.add(cb.equal(c.get("profesor.profesorId"), para));
		}
		
		if(!filtro.getEstado().equals(Constantes.S_NO_SELECCIONADO)){
			ParameterExpression<Boolean> para = cb.parameter(Boolean.class, String.valueOf(filtro.getEstado()));
		    criteria.add(cb.equal(c.get("estado =:estado"), para));
		}
		
		if(filtro.getFecha() != null){
			ParameterExpression<Date> para = cb.parameter(Date.class, String.valueOf(filtro.getFecha()));
		    criteria.add(cb.equal(c.get("fecha"), para));
		}
		
		return null;
	}
	


}
