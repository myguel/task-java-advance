package pe.edu.cibertec.core.dao;

import java.util.List;

public interface GenericDAO<T> {

	void save(T t);
	void update(T t);
	T get(T t);
	List<T>  getAll();
	void delete(T t);
}
