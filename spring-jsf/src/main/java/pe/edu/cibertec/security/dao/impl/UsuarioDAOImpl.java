package pe.edu.cibertec.security.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.edu.cibertec.core.dao.impl.AbstractDAOImpl;
import pe.edu.cibertec.security.dao.UsuarioDAO;
import pe.edu.cibertec.security.domain.Usuario;

@Repository(value="usuarioDAO")
public class UsuarioDAOImpl extends AbstractDAOImpl<Usuario> implements UsuarioDAO {

	@Override
	public Usuario obtenerUsuarioLogin(String usuario) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario=:usuario", Usuario.class);
		query.setParameter("usuario", usuario);
		return query.getSingleResult();
	}
}
