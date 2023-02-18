package main.parsers;

import main.converters.RomanToIntegerConverter;
import main.converters.TokenToRomanNumberConverter;
import main.enums.ValidationStatus;
import main.enums.ValidatorTypes;
import main.inputKeywords.InputKeywords;
import main.validators.ValidationResult;
import main.validators.ValidatorManager;
import main.workflow.MapManager;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class RomanNumeralQueryParser implements Parser {
    @Override
    public void parse(String inputLine) {
        String[] inputTokens = inputLine.split(InputKeywords.DELIMITER);
        int sizeOfPhrase = InputKeywords.ROMAN_NUMERAL_QUESTION_PHRASE.split(InputKeywords.DELIMITER).length;
        // how much is pish tegj glob glob
        String unitTokens = "";
        for (int index = sizeOfPhrase; index < inputTokens.length; index++) {
            unitTokens += inputTokens[index] + " ";
        }

        unitTokens = unitTokens.trim();

        String romanNumber = TokenToRomanNumberConverter.convertToRomanNumber(unitTokens);
        List<ValidationResult> validationResultLists = runValidatorsOnRomanNumber(romanNumber);

        for (ValidationResult result : validationResultLists) {
            if (result.getStatus().equals(ValidationStatus.INVALID)) {
                throw new InvalidParameterException(result.getMessage());
            }
        }

        RomanToIntegerConverter converter = new RomanToIntegerConverter();

        int romanNumberValue = converter.convertRomanToInteger(romanNumber);
        MapManager.getInstance().addRomanNumberQueryEntry(unitTokens, romanNumberValue);
    }

    private List<ValidationResult> runValidatorsOnRomanNumber(String romanNumber) {
        ValidatorManager manager = new ValidatorManager();
        ArrayList<ValidatorTypes> validatorTypes = new ArrayList<>();
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_C_OCCURRENCE_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_D_OCCURRENCE_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_I_OCCURRENCE_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_L_OCCURRENCE_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_M_OCCURRENCE_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_V_OCCURRENCE_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_X_OCCURRENCE_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_C_PLACEMENT_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_I_PLACEMENT_VALIDATOR);
        validatorTypes.add(ValidatorTypes.ROMAN_NUMERAL_X_PLACEMENT_VALIDATOR);

        return manager.runMultipleValidatorsByType(romanNumber, validatorTypes);
    }
}
