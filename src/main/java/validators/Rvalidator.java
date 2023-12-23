package validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;


@FacesValidator("rValidator")
public class Rvalidator implements Validator<Double> {

    private static final double R_MAX = 5.0;
    private static final double R_MIN = 2.0;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Double object) throws ValidatorException {
        if (object > R_MAX || object < R_MIN) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                            "Enter R"));
        }

    }
}
