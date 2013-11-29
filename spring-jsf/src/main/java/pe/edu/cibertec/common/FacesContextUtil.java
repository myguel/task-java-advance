package pe.edu.cibertec.common;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesContextUtil {

	public static void info(String titulo, String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,titulo,msg));
	}
	
	public static void info(String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",msg));
	}
	
	public static void warn(String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",msg));
	}
	
	public static void fatal(String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"",msg));
	}
	
	public static void error(String titulo,String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, msg));
	}
	
	public static void error(String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",msg));
	}
	
	public static void mensaje(String titulo, String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(titulo,msg));
	}
	
	public static String mensaje(String codigo){
		FacesContext facesContext = FacesContext.getCurrentInstance();
	    String messageBundleName = facesContext.getApplication().getMessageBundle();
	    Locale locale = facesContext.getViewRoot().getLocale();
	    ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
	    return bundle.getString(codigo);
	}
	

	public static void mensajeGuardar(){
		String guardar = "sistema.mensaje.guardar";
	    String mensaje = FacesContextUtil.properties(guardar);
	    FacesContextUtil.info(mensaje);
	}
	
	public static void mensajeActualizar(){
		String actualizar = "sistema.mensaje.actualizar";
	    String mensaje = FacesContextUtil.properties(actualizar);
	    FacesContextUtil.info(mensaje);
	}
	
	public static void mensajeEliminar(){
		String actualizar = "sistema.mensaje.eliminar";
	    String mensaje = FacesContextUtil.properties(actualizar);
	    FacesContextUtil.info(mensaje);
	}
	
	public static void mensajeError(){
		String error = "sistema.mensaje.error";
	    String mensaje = FacesContextUtil.properties(error);
	    FacesContextUtil.error(mensaje);
	}
	
	public static String properties(String codigo){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle= facesContext.getApplication().getResourceBundle(facesContext,"msg");
		String message = bundle.getString(codigo);
	    return message;
	}
}
