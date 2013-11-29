package pe.edu.cibertec.security.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.security.dao.UsuarioDAO;
import pe.edu.cibertec.security.domain.Usuario;


@SuppressWarnings("deprecation")
@Service("userDetailsService")
@Transactional(readOnly=true)
public class UsuarioSecurityServiceImpl implements UserDetailsService ,Serializable{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException{
		
		Usuario usuario=usuarioDAO.obtenerUsuarioLogin(username);
		User user = null;
		if(usuario != null){
			user = new User(usuario.getUsuario(), usuario.getPassword(), true, true, true, true, transformarListaPerfilesAListaGrantedAuthority(usuario.getRol()));;
		}
			
		if (user == null) {
			throw new UsernameNotFoundException("UserAccount for name \""+ username + "\" not found.");
		}
		return user;
	}

	
	private Collection<GrantedAuthority> transformarListaPerfilesAListaGrantedAuthority(String rol){
		Collection<GrantedAuthority> listaGrantedAuthority= new ArrayList<GrantedAuthority>();	
			GrantedAuthority grantedAuthority=new GrantedAuthorityImpl(rol);
			System.out.println(grantedAuthority.getAuthority());
			listaGrantedAuthority.add(grantedAuthority);
		return listaGrantedAuthority;
		
	}

}
