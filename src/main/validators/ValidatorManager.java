package main.validators;

import main.enums.ValidatorTypes;
import main.validators.mappingValidators.UnitTokenValidator;
import main.validators.romanNumeralsValidator.RomanNumeralSymbolValidator;
import main.validators.romanNumeralsValidator.occurenceValidators.*;
import main.validators.romanNumeralsValidator.placementValidators.RomanCPlacementValidator;
import main.validators.romanNumeralsValidator.placementValidators.RomanIPlacementValidator;
import main.validators.romanNumeralsValidator.RomanNumeralValidatorBase;
import main.validators.romanNumeralsValidator.placementValidators.RomanXPlacementValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidatorManager {

    private HashMap<ValidatorTypes, ValidatorBase> validators;

    public ValidatorManager() {
        validators = new HashMap<>();
        validators.put(ValidatorTypes.UNIT_TOKEN_VALIDATOR, new UnitTokenValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_C_OCCURRENCE_VALIDATOR, new RomanNumeralCOccurrenceValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_D_OCCURRENCE_VALIDATOR, new RomanNumeralDOccurrenceValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_I_OCCURRENCE_VALIDATOR, new RomanNumeralIOccurrenceValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_L_OCCURRENCE_VALIDATOR, new RomanNumeralLOccurrenceValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_M_OCCURRENCE_VALIDATOR, new RomanNumeralMOccurrenceValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_V_OCCURRENCE_VALIDATOR, new RomanNumeralVOccurrenceValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_X_OCCURRENCE_VALIDATOR, new RomanNumeralXOccurrenceValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_C_OCCURRENCE_VALIDATOR, new RomanNumeralCOccurrenceValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_C_PLACEMENT_VALIDATOR, new RomanCPlacementValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_I_PLACEMENT_VALIDATOR, new RomanIPlacementValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_X_PLACEMENT_VALIDATOR, new RomanXPlacementValidator());
        validators.put(ValidatorTypes.ROMAN_NUMERAL_SYMBOL_VALIDATOR, new RomanNumeralSymbolValidator());
    }


    public ValidationResult runValidatorByType(String input, ValidatorTypes validatorType) {
        return validators.get(validatorType).validate(input);
    }

    public List<ValidationResult> runValidators(String inputLine) {
        List<ValidationResult> validationResults = new ArrayList<>();
        for (ValidatorBase validator : validators.values()) {
            validationResults.add(validator.validate(inputLine));
        }
        return validationResults;
    }

    public List<ValidationResult> runMultipleValidatorsByType(String input, List<ValidatorTypes> validatorTypes) {
        List<ValidationResult> validationResults = new ArrayList<>();
        for (ValidatorTypes validatorType : validatorTypes) {
            validationResults.add(runValidatorByType(input, validatorType));
        }
        return validationResults;
    }

}
