package main.validators;

import main.enums.ValidationStatus;
import main.validators.interfaces.Validator;

public abstract class ValidatorBase implements Validator {

    @Override
    public abstract ValidationResult validate(String inputLine);

    protected ValidationResult checkInputEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return new ValidationResult(ValidationStatus.INVALID, "Input empty or null");
        }
        return new ValidationResult(ValidationStatus.VALID, "");
    }

}
