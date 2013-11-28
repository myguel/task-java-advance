package pe.edu.cibertec.common.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import pe.edu.cibertec.common.Constantes;

@FacesValidator("seleccionValidator")
public class SeleccionValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String campo = (String) component.getAttributes().get("campo");
		String valorSeleccion = String.valueOf(value);
		
		if(valorSeleccion.equals(Constantes.S_NO_SELECCIONADO)) {
			FacesMessage msg = new FacesMessage("Error de validacion", campo + "Requerido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
	
}
