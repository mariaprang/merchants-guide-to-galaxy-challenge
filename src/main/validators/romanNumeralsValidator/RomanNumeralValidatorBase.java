package main.validators.romanNumeralsValidator;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.ValidatorBase;
import main.validators.interfaces.Validator;

import java.util.List;

public abstract class RomanNumeralValidatorBase extends ValidatorBase {

    protected ValidationResult validateSymbolPlacement(String input, RomanSymbols symbol, List<String> validSymbolsList) {
        for (int index = 0; index < input.length() - 1; index++) {
            String currentSymbol = String.valueOf(input.charAt(index));
            if (!currentSymbol.equals(symbol.getRomanNumeral())) {
                continue;
            }
            String nextOfCurrentSymbol = String.valueOf(input.charAt(index + 1));
            if (!validSymbolsList.contains(nextOfCurrentSymbol)) {
                String errorMessage = currentSymbol + " cannot be placed before " + nextOfCurrentSymbol;
                return new ValidationResult(ValidationStatus.INVALID, errorMessage);
            }
        }
        return new ValidationResult(ValidationStatus.VALID, "");
    }

    protected ValidationResult validateSymbolOccurrence(String input, RomanSymbols symbol, int numberOfOccurences) {
        for (int index = 0; index < input.length() - 1; index++) {
            if (index == input.length() - 1) {
                break;
            }
            String currentSymbol = String.valueOf(input.charAt(index));
            String nextSymbol = String.valueOf(input.charAt(index + 1));
            int symbolOccurence = 0;
            while (nextSymbol.equals(currentSymbol)) {
                symbolOccurence++;
                if(index + symbolOccurence >= input.length()){
                    break;
                }
                nextSymbol = String.valueOf(input.charAt(index + symbolOccurence));
            }
            if (symbolOccurence > numberOfOccurences) {
                String errorMessage = "Symbol " + symbol + " cannot be repeated " + symbolOccurence + " times";
                return new ValidationResult(ValidationStatus.INVALID, errorMessage);
            }
            index = index + symbolOccurence;
        }
        return new ValidationResult(ValidationStatus.VALID, "");
    }


}