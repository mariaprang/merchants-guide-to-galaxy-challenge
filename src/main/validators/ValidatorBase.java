package main.validators;

import main.enums.ValidationStatus;
import main.validators.interfaces.Validator;

/**
 * Base class of every validator
 */
public abstract class ValidatorBase implements Validator {

    @Override
    public abstract ValidationResult validate(String inputLine);

    /**
     * Checks input for empty or null string
     * @param input - a single line of input
     * @return - ValidationResult - error message + status (Invalid, Valid)
     */
    protected ValidationResult checkInputEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return new ValidationResult(ValidationStatus.INVALID, "Input empty or null");
        }
        return new ValidationResult(ValidationStatus.VALID, "");
    }

}
