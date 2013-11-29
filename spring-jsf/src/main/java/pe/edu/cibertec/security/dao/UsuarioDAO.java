package pe.edu.cibertec.security.dao;

import pe.edu.cibertec.security.domain.Usuario;

public interface UsuarioDAO {

	public Usuario obtenerUsuarioLogin(String username);

}
