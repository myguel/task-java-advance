package pe.edu.cibertec.core.dao;

import java.io.Serializable;
import java.util.List;

public interface  GenericDAO<T extends Serializable>  {

	 long count();
     T save(T t);
     void delete(Object id);
     T get(Object id);    
     List<T> getAll();
     T update(T t);
}
