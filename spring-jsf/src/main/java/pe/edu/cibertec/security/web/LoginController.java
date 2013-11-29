package pe.edu.cibertec.security.web;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import pe.edu.cibertec.exception.BusinessException;
import pe.edu.cibertec.security.domain.Usuario;
import pe.edu.cibertec.security.service.UsuarioService;


@ManagedBean(name="loginController")
@SessionScoped
public class LoginController implements Serializable{
	
	private static final long serialVersionUID = -2645449963368597255L;

	private Usuario usuario;
	
//	@ManagedProperty(value="#{authenticationService}")
//	private AuthenticationService authenticationService;
//	
	@ManagedProperty(value="#{authenticationManager}")    
    private AuthenticationManager authenticationManager;

	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	public LoginController(){
		usuario=new Usuario();
	}
	


	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
    
	public String iniciarSession() {
		try {
			
		    Authentication request = new UsernamePasswordAuthenticationToken(usuario.getUsuario(), usuario.getPassword());
            Authentication authentication = authenticationManager.authenticate(request);
            UserDetails userDetails=(UserDetails) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);
           Collection<GrantedAuthority> authorities= (Collection<GrantedAuthority>) userDetails.getAuthorities();
           for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println(grantedAuthority);
           }
					
//			boolean success = authenticationService.login(usuario.getUsuario(), usuario.getPassword());
			if (authentication.getPrincipal()!=null){
//				usuario= usuarioService.obtenerUsuarioLogin(userDetails.getUsername());
				if(usuario.getUsuario()!= null && authorities.size()>0 ){
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rol", authorities);
					return "/pages/secure/GestionLaboratorios.jsf?faces-redirect=true";
				}else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"","No tiene permisos para ingresar al sistema"));			
					return "";
				}
				
			}
			else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Usuario o contrase�a incorrecta"));				
				return "";
			}
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
			return "";
		}
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"","No se pudo ingresar al sistema intentelo m�s tarde"));
			return "";
		} 
	}
	
		
	public void limpiar(){
		usuario=new Usuario();
	}
	
	public String cerrarSession(){
		usuario=new Usuario();
		System.out.println("cerro la session");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("rol");
		SecurityContextHolder.clearContext();
//		authenticationService.logout();
		return "/pages/public/login-interno.xhtml&faces-redirect=true";
	}
	
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
//
//	public AuthenticationService getAuthenticationService() {
//		return authenticationService;
//	}
//
//	public void setAuthenticationService(AuthenticationService authenticationService) {
//		this.authenticationService = authenticationService;
//	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
