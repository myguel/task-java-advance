package pe.edu.cibertec.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.edu.cibertec.core.dao.GenericDAO;

public  abstract class AbstractDAOImpl<T extends Serializable>  implements GenericDAO<T>{

	private static final Logger logger=LoggerFactory.getLogger(AbstractDAOImpl.class);

	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public AbstractDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        
        logger.info(t.toString());
        ParameterizedType pt = (ParameterizedType) t;
        logger.info(pt.toString());
        System.out.println(pt.getActualTypeArguments()[0]);
        logger.info(pt.getActualTypeArguments()[0].toString());
        logger.info(pt.getClass().toString());
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }
	public AbstractDAOImpl(Class<T> t){
		this.type=t;
		
	}
	
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public long count() {
		logger.info("AbstractDAOImpl: Count");
		String entity = type.getSimpleName();
		final StringBuffer queryString = new StringBuffer("select count(ent) from " + entity + " ent");
        final Query query = this.em.createQuery(queryString.toString());
        return (Long) query.getSingleResult();
	}

	@Override
	public T save(final T t) {
		logger.info("AbstractDAOImpl: save");
		em.persist(t);
		return t;
	}

	@Override
	public void delete(final Object id) {
		logger.info("AbstractDAOImpl: delete");
		em.remove(em.getReference(type, id));
	}

	@Override
	public T get(final Object id) {
		logger.info("AbstractDAOImpl: get");
		return em.find(type, id);
	}

	@Override
	public T update(final T t) {
		logger.info("AbstractDAOImpl: update");
		return em.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		 logger.info("AbstractDAOImpl: getAll");
		  String entity = type.getSimpleName();
		  Query query = em.createQuery("select ent from " + entity + " ent"); 
    	return query.getResultList();
	}
}
