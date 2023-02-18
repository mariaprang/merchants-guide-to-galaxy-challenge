package main.validators.romanNumeralsValidator;

import main.enums.InputTypes;
import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.interfaces.Validator;

public class UniqueSymbolValidator extends RomanNumeralValidatorBase {
    @Override
    public ValidationResult validate(String inputLine) {

        ValidationResult checkInputResult = checkInputEmpty(inputLine);
        if (checkInputResult.getStatus().equals(ValidationStatus.INVALID)) {
            return checkInputResult;
        }
        return null;
    }
}
