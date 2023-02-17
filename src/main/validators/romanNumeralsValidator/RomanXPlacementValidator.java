package main.validators.romanNumeralsValidator;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.validators.ValidationResult;

import java.util.Arrays;

public class RomanXPlacementValidator extends RomanNumeralValidatorBase {

    @Override
    public ValidationResult validate(String inputLine) {
        return validateSymbolPlacement(inputLine, RomanSymbols.X,
                Arrays.asList(RomanSymbols.L, RomanSymbols.C));
    }
}
