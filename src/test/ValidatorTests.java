package test;

import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.romanNumeralsValidator.RomanIPlacementValidator;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTests {

    @Test
    public void romanIPlacementValidatorValidTest() {
        RomanIPlacementValidator validator = new RomanIPlacementValidator();
        ValidationResult resultIV = validator.validate("IV");
        Assert.assertEquals(ValidationStatus.VALID, resultIV.getStatus());

        ValidationResult resultIX = validator.validate("IX");
        Assert.assertEquals(ValidationStatus.VALID, resultIX.getStatus());

        ValidationResult resultII = validator.validate("II");
        Assert.assertEquals(ValidationStatus.VALID, resultII.getStatus());

        ValidationResult resultIII = validator.validate("III");
        Assert.assertEquals(ValidationStatus.VALID, resultIII.getStatus());
    }

    @Test
    public void romanIPlacementValidatorInvalidTest() {
        RomanIPlacementValidator validator = new RomanIPlacementValidator();
        ValidationResult resultIL = validator.validate("IL");
        Assert.assertEquals(ValidationStatus.INVALID, resultIL.getStatus());

        ValidationResult resultIC = validator.validate("IC");
        Assert.assertEquals(ValidationStatus.INVALID, resultIC.getStatus());

        ValidationResult resultID = validator.validate("ID");
        Assert.assertEquals(ValidationStatus.INVALID, resultID.getStatus());

        ValidationResult resultIM = validator.validate("IM");
        Assert.assertEquals(ValidationStatus.INVALID, resultIM.getStatus());
    }


}
