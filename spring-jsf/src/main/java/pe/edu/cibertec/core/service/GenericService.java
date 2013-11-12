package pe.edu.cibertec.core.service;

import java.util.List;

public interface GenericService<T> {

	void save(T t);
	void update(T t);
	T get(T t);
	List<T>  getAll();
	void delete(T t);
}
