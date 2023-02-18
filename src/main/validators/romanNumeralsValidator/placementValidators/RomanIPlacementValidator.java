package main.validators.romanNumeralsValidator.placementValidators;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.romanNumeralsValidator.RomanNumeralValidatorBase;

import java.util.Arrays;

public class RomanIPlacementValidator extends RomanNumeralValidatorBase {

    @Override
    public ValidationResult validate(String inputLine) {
        ValidationResult checkInputResult = checkInputEmpty(inputLine);
        if (checkInputResult.getStatus().equals(ValidationStatus.INVALID)) {
            return checkInputResult;
        }
        return validateSymbolPlacement(inputLine, RomanSymbols.I,
                Arrays.asList(RomanSymbols.V, RomanSymbols.X, RomanSymbols.I));
    }
}
