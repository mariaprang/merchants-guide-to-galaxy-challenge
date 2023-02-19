package main.validators.mappingValidators;

import main.enums.ValidationStatus;
import main.inputKeywords.InputKeywords;
import main.validators.ValidationResult;
import main.validators.ValidatorBase;
import main.workflow.MapManager;

import java.util.Set;

public class UnitTokenValidator extends ValidatorBase {

    /**
     * This method validates that a unit token passed as a parameter, such as "glob" or "pish" is indeed a valid
     * unit based on the "dictionary" obtained from a parser
     *
     * @param inputLine - unit and commodity phrase, such as "pish pish Iron"
     * @return - ValidationResult - error message + status (Invalid, Valid)
     */

    @Override
    public ValidationResult validate(String inputLine) {

        ValidationResult checkInputResult = checkInputEmpty(inputLine);
        if (checkInputResult.getStatus().equals(ValidationStatus.INVALID)) {
            return checkInputResult;
        }

        String[] unitTokens = inputLine.split(InputKeywords.DELIMITER);
        MapManager mapManager = MapManager.getInstance();
        Set<String> validUnitTokens = mapManager.getUnitToRomanNumeralMap().keySet();
        for (int index = 0; index < unitTokens.length - 1; index++) {
            if (!validUnitTokens.contains(unitTokens[index])) {
                return new ValidationResult (ValidationStatus.INVALID, "Unit " + unitTokens[index] + " is unknown!");
            }
        }
        return new ValidationResult (ValidationStatus.VALID, "");
    }
}
