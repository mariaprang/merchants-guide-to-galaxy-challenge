package main.validators.mappingValidators;

import main.enums.ValidationStatus;
import main.inputKeywords.InputKeywords;
import main.validators.ValidationResult;
import main.validators.interfaces.Validator;
import main.workflow.MapManager;

import java.util.Set;

public class UnitTokenValidator implements Validator {

    /**
     * This method validates that a unit token passed as a parameter, such as "glob" or "pish" is indeed a valid
     * unit based on the "dictionary" obtained from a parser
     *
     * @param inputLine - unit and commodity phrase, such as "pish pish Iron"
     * @return
     */

    @Override
    public ValidationResult validate(String inputLine) {
        return null;
    }
}
