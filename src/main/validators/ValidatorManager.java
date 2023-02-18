package main.validators;

import main.validators.romanNumeralsValidator.placementValidators.RomanCPlacementValidator;
import main.validators.romanNumeralsValidator.placementValidators.RomanIPlacementValidator;
import main.validators.romanNumeralsValidator.RomanNumeralValidatorBase;

import java.util.ArrayList;
import java.util.List;

public class ValidatorManager {

    private ArrayList<RomanNumeralValidatorBase> validators;

    public ValidatorManager() {
        this.validators = new ArrayList<>();
        validators.add(new RomanCPlacementValidator());
        validators.add(new RomanIPlacementValidator());
        validators.add(new RomanCPlacementValidator());
        // TODO: add more validators

    }

    public List<ValidationResult> runValidators(String inputLine) {
        List<ValidationResult> validationResults = new ArrayList<>();
        for (RomanNumeralValidatorBase validator : validators) {
            validationResults.add(validator.validate(inputLine));
        }
        return validationResults;
    }

}
