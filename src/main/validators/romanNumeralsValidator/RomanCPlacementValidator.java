package main.validators.romanNumeralsValidator;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.validators.ValidationResult;

import java.util.Arrays;

public class RomanCPlacementValidator extends RomanNumeralValidatorBase {

    @Override
    public ValidationResult validate(String inputLine) {
        return validateSymbolPlacement(inputLine, RomanSymbols.C,
                Arrays.asList(RomanSymbols.D, RomanSymbols.M));
    }
}
