package main.validators.romanNumeralsValidator;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.validators.ValidationResult;
import main.validators.interfaces.Validator;

import java.util.List;

public abstract class RomanNumeralValidatorBase implements Validator {

    public abstract ValidationResult validate(String inputLine);

    protected ValidationResult validateSymbolPlacement(String input, RomanSymbols symbol, List<RomanSymbols> validSymbolsList) {
        return null;
    }

    protected ValidationResult validateSymbolOccurrence(String input, RomanSymbols symbols, int numberOfOccurences) {
        return null;
    }

}