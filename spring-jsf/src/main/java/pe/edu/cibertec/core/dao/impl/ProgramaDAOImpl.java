package pe.edu.cibertec.core.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.edu.cibertec.core.dao.ProgramaDAO;
import pe.edu.cibertec.core.domain.Programa;

@Repository
public class ProgramaDAOImpl extends AbstractDAOImpl<Programa> implements ProgramaDAO{

	@Override
	public List<Programa> getProgramas() {
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT NEW pe.edu.cibertec.core.domain.Programa(p.programaId,p.nombre) ");
		sql.append("FROM Programa AS p");
		  TypedQuery<Programa> query = em.createQuery(sql.toString(), Programa.class);
		  List<Programa> results = query.getResultList();
		  return results;
	}
}
