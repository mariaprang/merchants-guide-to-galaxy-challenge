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

public class MetalPriceInformationParser implements Parser {

    @Override
    public void parse(String inputLine) {
        //glob glob Silver is 34 Credits

        String[] tokens = inputLine.split(InputKeywords.DELIMITER);
        int credits = 0;
        String unitsAndCommodity = "";
        for (int index = 0; index < tokens.length; index++) {
            if (!tokens[index].equals(InputKeywords.MATCH_PHRASE)) {
                unitsAndCommodity += tokens[index] + InputKeywords.DELIMITER;

            } else {
                credits = Integer.valueOf(tokens[index + 1]);
                break;
            }
        }

        String[] unitsAndCommodityTokens = unitsAndCommodity.trim().split(InputKeywords.DELIMITER);
        String units = "";
        for (int index = 0; index < unitsAndCommodityTokens.length - 1; index++) {
            units += unitsAndCommodityTokens[index] + InputKeywords.DELIMITER;
        }
        String commodityString = unitsAndCommodityTokens[unitsAndCommodityTokens.length - 1];
        MaterialTypes materialType = MaterialTypes.getMaterialByValue(commodityString);

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

        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        int metalValueInteger = converter.convertRomanToInteger(romanNumber);
        MapManager.getInstance().addCommodityToCreditEntry(materialType, ( (double) credits / metalValueInteger));

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
