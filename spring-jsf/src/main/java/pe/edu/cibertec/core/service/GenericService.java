package pe.edu.cibertec.core.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
/**
 * 
 * @author myguel
 *
 *@version 1.0
 * <p> Interface generica que abstrae los metodos mas comunes en el sistema</p>
 * @param <T>
 */
public interface GenericService<T> {

	/**
	 * <p>Metodo que permite persistir en db, a su vez el metodo es securizado para algunos perfiles.</p>
	 * @param t
	 */
	@PreAuthorize("hasAnyRole('ROL_ADMINISTRADOR', 'ROL_DIRECTOR','ROL_USER')")
	void save(T t);
        
        /**
	 * <p>Metodo que permite actualizar un registro en db, a su vez el metodo es securizado para algunos perfiles.</p>
	 * @param t
	 */
	@PreAuthorize("hasAnyRole('ROL_ADMINISTRADOR', 'ROL_DIRECTOR')")
	void update(T t);
        /**
	 * <p>Metodo que permite eliminar en db, a su vez el metodo es securizado para algunos perfiles.</p>
	 * @param t
	 */
	@PreAuthorize("hasAnyRole('ROL_ADMINISTRADOR')")
	void delete(T t);
	T getById(T t);
        /**
	 * <p>Metodo que permite listar los registros de una tabla en db, el metodo no es securizado.</p>
	 * sin parámetros
	 */
	List<T>  getAll();
}
