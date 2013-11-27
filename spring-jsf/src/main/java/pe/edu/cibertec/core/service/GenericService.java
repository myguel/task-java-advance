package pe.edu.cibertec.core.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

public interface GenericService<T> {

	@PreAuthorize("hasAnyRole('ROL_ADMINISTRADOR', 'ROL_DIRECTOR','ROL_USER')")
	void save(T t);
	@PreAuthorize("hasAnyRole('ROL_ADMINISTRADOR', 'ROL_DIRECTOR')")
	void update(T t);
	@PreAuthorize("hasAnyRole('ROL_ADMINISTRADOR')")
	void delete(T t);
	T getById(T t);
	List<T>  getAll();
}
