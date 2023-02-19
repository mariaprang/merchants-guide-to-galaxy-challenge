package main.parsers;

import main.enums.RomanSymbols;
import main.enums.ValidationStatus;
import main.enums.ValidatorTypes;
import main.inputKeywords.InputKeywords;
import main.validators.ValidationResult;
import main.validators.ValidatorManager;
import main.workflow.MapManager;

import java.security.InvalidParameterException;

/**
 * Parser for mapping phrases, such as "glob is I"
 */
public class MapperParser implements Parser {

    /**
     * Parser calls the MapManager and adds unitToken "glob" as a key for value "I"
     * @param inputLine - single input line, such as "glob is I"
     */
    @Override
    public void parse(String inputLine) {
        MapManager mapManager = MapManager.getInstance();
        String[] inputTokens = inputLine.split(InputKeywords.DELIMITER);
        ValidationResult validationResult = new ValidatorManager().runValidatorByType(inputTokens[2], ValidatorTypes.ROMAN_NUMERAL_SYMBOL_VALIDATOR);
        if (validationResult.getStatus().equals(ValidationStatus.VALID)) {
            mapManager.addUnitToRomanNumeralEntry(inputTokens[0], RomanSymbols.valueOf(inputTokens[2]));
            return;
        }
        throw new InvalidParameterException(validationResult.getMessage());
    }

}
