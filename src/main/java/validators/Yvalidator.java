package validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;


@FacesValidator("yValidator")
public class Yvalidator implements Validator<Double> {

    private static final double Y_MAX = 5.0;
    private static final double Y_MIN = -5.0;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Double object) throws ValidatorException {
        if (object == null) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                            "Enter y"));
        }
        if (object > Y_MAX || object < Y_MIN) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                            "Y should be [-5,5]"));
        }


    }
}

