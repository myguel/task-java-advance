package pe.edu.cibertec.security.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.security.service.AuthenticationService;


@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager;
	
	public boolean login(String username, String password) {
		try {
			Authentication authenticate = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							username, password));
			if (authenticate.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(
						authenticate);	
				
				return true;
			}
		} catch (AuthenticationException e) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		
	}

	
}
