package main.validators.romanNumeralsValidator;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.validators.ValidationResult;

import java.util.Arrays;

public class RomanIPlacementValidator extends RomanNumeralValidatorBase {

    @Override
    public ValidationResult validate(String inputLine) {
        return validateSymbolPlacement(inputLine, RomanSymbols.I,
                Arrays.asList(RomanSymbols.V, RomanSymbols.X, RomanSymbols.I));
    }
}
