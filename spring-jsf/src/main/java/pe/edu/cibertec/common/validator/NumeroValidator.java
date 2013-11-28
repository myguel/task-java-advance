package pe.edu.cibertec.common.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("numeroValidator")
public class NumeroValidator implements Validator {
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		if(value!=null && !value.toString().equals("")){
			String campo = (String) component.getAttributes().get("campo");
			String numero = value == null?"": value.toString();
			if(!Validador.validarNumeros(numero)) {
				FacesMessage msg = new FacesMessage("Error de validaci�n", campo + ": Caracter no v�lido");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		}
		
	}

}
