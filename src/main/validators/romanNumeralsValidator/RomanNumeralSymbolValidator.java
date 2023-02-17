package main.validators.romanNumeralsValidator;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.interfaces.Validator;

public class RomanNumeralSymbolValidator  extends RomanNumeralValidatorBase  {

    /**
     * This method validates that a roman symbol in the mapping phrase, such as "glob is I" is indeed a valid roman
     * numeral symbol, which means it has to be one of the following: I, V, X, L, C, D, M
     * @param romanSymbol - a roman symbol, such as I or V
     * @return
     */

    @Override
    public ValidationResult validate(String romanSymbol)  {

       return null;
    }
}
