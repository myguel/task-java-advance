package pe.edu.cibertec.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.common.Filtro;
import pe.edu.cibertec.core.dao.LaboratorioDAO;
import pe.edu.cibertec.core.domain.Laboratorio;

@Repository("laboratorioDAO")
public class LaboratorioDAOImpl extends AbstractDAOImpl<Laboratorio> implements
		LaboratorioDAO {
	private static final Logger logger = LoggerFactory.getLogger(LaboratorioDAOImpl.class);


	@SuppressWarnings("unchecked")
	@Override
	public List<Laboratorio> findByParameters(Filtro filtro) {
		logger.info("findByParameters");
		
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT l FROM Laboratorio l ");
		sql.append("JOIN FETCH l.programa pr ");
		sql.append("JOIN FETCH l.profesor p ");
		sql.append(" WHERE 1=1 ");
		if(filtro.getNombre()!=null){
			sql.append(" AND l.nombre LIKE :nombre ");			
		}
		if(filtro.getPrograma()!=null&&filtro.getPrograma()>0){
			sql.append(" AND l.programa.programaId = :programa");			
		}
		if(filtro.getProfesor()!=null&&filtro.getProfesor()>0){
			sql.append(" AND l.profesor.profesorId = :profesor");			
		}
		if(filtro.getEnabled()!=null){
			sql.append(" AND l.estado = :estado");			
		}
		if(filtro.getFecha()!=null){
			sql.append(" AND l.fecha = :fecha");			
		}
		Query query = em.createQuery(sql.toString());
		if(filtro.getNombre()!=null){
			query.setParameter("nombre", "%"+filtro.getNombre()+"%");			
		}
		if(filtro.getPrograma()!=null&&filtro.getPrograma()>0){
			query.setParameter("programa", filtro.getProfesor());			
		}
		if(filtro.getProfesor()!=null&&filtro.getProfesor()>0){
			query.setParameter("profesor", filtro.getPrograma());			
		}
		if(filtro.getEnabled()!=null){
			query.setParameter("estado", filtro.getEnabled());			
		}
		if(filtro.getFecha()!=null){
			query.setParameter("fecha", filtro.getFecha());			
		}
		return query.getResultList();
	}

}
