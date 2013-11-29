package pe.edu.cibertec.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.security.dao.UsuarioDAO;
import pe.edu.cibertec.security.domain.Usuario;
import pe.edu.cibertec.security.service.UsuarioService;

@Service(value="usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario obtenerUsuarioLogin(String username) {
		return usuarioDAO.obtenerUsuarioLogin(username);
	}

}
