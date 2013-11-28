package pe.edu.cibertec.core.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import pe.edu.cibertec.common.Constantes;
import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.core.dao.ProgramaDAO;
import pe.edu.cibertec.core.domain.Laboratorio;
import pe.edu.cibertec.core.domain.Programa;

@Repository(value = "programaDAO")
public class ProgramaDAOImpl extends AbstractDAOImpl<Programa> implements
		ProgramaDAO {

	@Override
	public List<Programa> getProgramas() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NEW pe.edu.cibertec.core.domain.Programa(p.programaId,p.nombre) ");
		sql.append("FROM Programa AS p");
		TypedQuery<Programa> query = em.createQuery(sql.toString(),
				Programa.class);
		List<Programa> results = query.getResultList();
		return results;
	}

	@Override
	public List<Laboratorio> getAll(Filtro filtro) {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT l ");
//		sql.append("FROM Laboratorio as l");
//		sql.append("WHERE 1=1 ");
//		
//		if(!filtro.getNombre().equals("")){
//			sql.append("AND l.nombre =:nombre ");
//		}
//		
//		if(!filtro.getPrograma().equals(Constantes.S_NO_SELECCIONADO)){
//			sql.append("AND l.programa.programaId =:programa ");
//		}
//		
//		if(!filtro.getProfesor().equals(Constantes.S_NO_SELECCIONADO)){
//			sql.append("AND l.profesor.profesorId =:profesor ");
//		}
//		
//		if(!filtro.getEstado().equals(Constantes.S_NO_SELECCIONADO)){
//			sql.append("AND l.estado =:estado ");
//		}
//		
//		if(filtro.getFecha() != null){
//			sql.append("AND l.fecha =:fecha ");
//		}
//		
//		TypedQuery<Laboratorio> query = em.createQuery(sql.toString(), Laboratorio.class);
//		List<Laboratorio> results = query.getResultList();
		
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 
		CriteriaQuery<Laboratorio> criteriaQuery = cb.createQuery(Laboratorio.class);
		Root<Laboratorio> c = criteriaQuery.from(Laboratorio.class);
		ParameterExpression<Integer> p = cb.parameter(Integer.class);
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
