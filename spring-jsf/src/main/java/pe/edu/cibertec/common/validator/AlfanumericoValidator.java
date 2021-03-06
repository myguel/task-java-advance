package pe.edu.cibertec.common.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("alfanumericoValidator")
public class AlfanumericoValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(value!=null && !value.toString().equals("")){
			String campo = (String) component.getAttributes().get("campo");
			String alfanumerico = value == null?"": value.toString();
			if(!Validador.validarAlfanumerico(alfanumerico)) {
				FacesMessage msg = new FacesMessage("Error de validacion", campo + ": Caracter no valido.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		}
		
	}
}
