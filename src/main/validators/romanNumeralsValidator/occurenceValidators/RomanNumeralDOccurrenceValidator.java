package main.validators.romanNumeralsValidator.occurenceValidators;

import main.enums.RomanSymbols;
import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.romanNumeralsValidator.RomanNumeralValidatorBase;

public class RomanNumeralDOccurrenceValidator extends RomanNumeralValidatorBase {

    @Override
    public ValidationResult validate(String inputLine) {
        ValidationResult checkInputResult = checkInputEmpty(inputLine);
        if (checkInputResult.getStatus().equals(ValidationStatus.INVALID)) {
            return checkInputResult;
        }
        return validateSymbolOccurrence(inputLine, RomanSymbols.D, 1);
    }
}
