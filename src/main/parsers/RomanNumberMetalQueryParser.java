package main.parsers;

import main.converters.RomanToIntegerConverter;
import main.converters.TokenToRomanNumberConverter;
import main.enums.MaterialTypes;
import main.enums.ValidationStatus;
import main.enums.ValidatorTypes;
import main.inputKeywords.InputKeywords;
import main.validators.ValidationResult;
import main.validators.ValidatorManager;
import main.workflow.MapManager;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser parsing a single string, such as "how many Credits is glob prok Silver" by converting the unit tokens to
 * a roman number, calling validators for checking if the roman number is valid and then calculating credits based on the
 * mapped information in the MapManager about this specific metal type
 */
public class RomanNumberMetalQueryParser implements Parser {

    /**
     * Converts a unit token phrase, such as "glob prok Silver" to a roman number and evaluates its credit value
     * @param inputLine - single input line, such as "how many Credits is glob prok Silvers"
     */
    @Override
    public void parse(String inputLine) {
        String[] inputTokens = inputLine.split(InputKeywords.DELIMITER);
        int sizeOfPhrase = InputKeywords.CREDIT_PHRASE.split(InputKeywords.DELIMITER).length;
        String unitTokens = "";
        for (int index = sizeOfPhrase; index < inputTokens.length; index++) {
            if(!inputTokens[index].equals("?")){
                unitTokens += inputTokens[index] + " ";

            }
        }
        unitTokens = unitTokens.trim(); // glob prok Silver

        String[] unitsAndCommodityTokens = unitTokens.trim().split(InputKeywords.DELIMITER);
        String units = "";
        for (int index = 0; index < unitsAndCommodityTokens.length - 1; index++) {
            units += unitsAndCommodityTokens[index] + InputKeywords.DELIMITER;
        }

        ValidatorManager manager = new ValidatorManager();
        ValidationResult validationResult = manager.runValidatorByType(units, ValidatorTypes.UNIT_TOKEN_VALIDATOR);
        if (validationResult.getStatus().equals(ValidationStatus.INVALID)) {
            throw new InvalidParameterException(validationResult.getMessage());
        }



        String commodityString = unitsAndCommodityTokens[unitsAndCommodityTokens.length - 1];
        String romanNumber = TokenToRomanNumberConverter.convertToRomanNumber(units.trim());
        List<ValidationResult> validationResultList = runValidatorsOnRomanNumber(romanNumber);

        List<String> errorMessages = new ArrayList<>();
        for (ValidationResult result : validationResultList) {
            if (result.getStatus().equals(ValidationStatus.INVALID)) {
                errorMessages.add(result.getMessage());
            }
        }

        if (errorMessages.size() > 0) {
            throw new InvalidParameterException(errorMessages.toArray().toString());
        }

        MaterialTypes materialType = MaterialTypes.getMaterialByValue(commodityString);

        double metalValue = MapManager.getInstance().getCreditByCommodity(materialType);
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        int romanNumberInteger = converter.convertRomanToInteger(romanNumber);

        double credits = romanNumberInteger * metalValue;

        MapManager.getInstance().addCreditQueryEntry(unitTokens, credits);

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
