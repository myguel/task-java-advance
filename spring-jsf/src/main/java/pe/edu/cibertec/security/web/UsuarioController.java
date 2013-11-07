package pe.edu.cibertec.security.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.cibertec.security.domain.Usuario;
import pe.edu.cibertec.security.service.UsuarioService;

@ManagedBean(name="mbUsuario")
@ViewScoped
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
