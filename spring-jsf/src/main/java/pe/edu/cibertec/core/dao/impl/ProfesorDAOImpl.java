package pe.edu.cibertec.core.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.edu.cibertec.core.dao.ProfesorDAO;
import pe.edu.cibertec.core.domain.Profesor;
@Repository
public class ProfesorDAOImpl  extends AbstractDAOImpl<Profesor> implements ProfesorDAO {

	@Override
	public List<Profesor> getProfesors() {
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT NEW pe.edu.cibertec.core.domain.Profesor(p.profesorId,p.apellido,p.nombre) ");
		sql.append("FROM Profesor AS p");
		  TypedQuery<Profesor> query = em.createQuery(sql.toString(), Profesor.class);
		  List<Profesor> results = query.getResultList();
		  return results;
	}
}
