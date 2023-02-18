package main.validators.mappingValidators;

import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.ValidatorBase;

public class UnitTokenValidator extends ValidatorBase {

    /**
     * This method validates that a unit token passed as a parameter, such as "glob" or "pish" is indeed a valid
     * unit based on the "dictionary" obtained from a parser
     *
     * @param inputLine - unit and commodity phrase, such as "pish pish Iron"
     * @return
     */

    @Override
    public ValidationResult validate(String inputLine) {
        ValidationResult checkInputResult = checkInputEmpty(inputLine);
        if (checkInputResult.getStatus().equals(ValidationStatus.INVALID)) {
            return checkInputResult;
        }
        return null;
    }
}
