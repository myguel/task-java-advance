package pe.edu.cibertec.security.web;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.context.RequestContext;

import pe.edu.cibertec.exception.BusinessException;
import pe.edu.cibertec.security.domain.Usuario;
import pe.edu.cibertec.security.service.AuthenticationService;
import pe.edu.cibertec.security.service.UsuarioService;


@ManagedBean(name="loginController")
@SessionScoped
public class LoginController implements Serializable{
	
	private static final long serialVersionUID = -2645449963368597255L;

	private Usuario usuario;
	
	@ManagedProperty(value="#{authenticationService}")
	private AuthenticationService authenticationService;
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	public LoginController(){
		usuario=new Usuario();
	}
	
	public String iniciarSession() {
		try {
			
			boolean success = authenticationService.login(usuario.getUsuario(), usuario.getPassword());
			if (success){
				usuario= usuarioService.obtenerUsuarioLogin(usuario.getUsuario());
				if(usuario.getRol()!= null && !usuario.getRol().equals("") ){
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rol", usuario.getRol());
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
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("perfil");
		authenticationService.logout();
		return "/pages/zonaPrivada/login-interno.xhtml&faces-redirect=true";
	}
	
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
