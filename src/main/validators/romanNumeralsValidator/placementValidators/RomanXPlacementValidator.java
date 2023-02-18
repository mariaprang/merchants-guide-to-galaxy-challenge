package main.validators.romanNumeralsValidator.placementValidators;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.romanNumeralsValidator.RomanNumeralValidatorBase;

import java.util.Arrays;

public class RomanXPlacementValidator extends RomanNumeralValidatorBase {

    @Override
    public ValidationResult validate(String inputLine) {
        ValidationResult checkInputResult = checkInputEmpty(inputLine);
        if (checkInputResult.getStatus().equals(ValidationStatus.INVALID)) {
            return checkInputResult;
        }
        return validateSymbolPlacement(inputLine, RomanSymbols.X,
                Arrays.asList(RomanSymbols.L.getRomanNumeral(), RomanSymbols.C.getRomanNumeral()));
    }
}
