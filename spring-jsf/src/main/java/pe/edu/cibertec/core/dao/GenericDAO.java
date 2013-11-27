package pe.edu.cibertec.core.dao;

import java.io.Serializable;
import java.util.List;

public interface  GenericDAO<T extends Serializable>  {

	 long count();
         /**
         * <p>Metodo que permite persistir en db</p>
	 * @param t
	 */
     T save(T t);
     /**
	 * <p>Metodo que permite eliminar un registro en db.</p>
	 * @param id
	 */
     void delete(Object id);
     /**
	 * <p>Metodo que permite obtener un registro de la db.</p>
	 * @param id
	 */
     T get(Object id);    
     /**
	 * <p>Metodo que permite listar los registros de una tabla en db.</p>
	 * sin parámetros
	 */
     List<T> getAll();
     /**
	 * <p>Metodo que permite actualizar un registro en db.</p>
	 * @param t
	 */
     T update(T t);
}
