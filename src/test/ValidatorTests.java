package test;

import main.enums.ValidationStatus;
import main.validators.ValidationResult;
import main.validators.ValidatorBase;
import main.validators.mappingValidators.UnitTokenValidator;
import main.validators.romanNumeralsValidator.*;
import main.validators.romanNumeralsValidator.occurenceValidators.*;
import main.validators.romanNumeralsValidator.placementValidators.RomanCPlacementValidator;
import main.validators.romanNumeralsValidator.placementValidators.RomanIPlacementValidator;
import main.validators.romanNumeralsValidator.placementValidators.RomanXPlacementValidator;
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

    @Test
    public void inputLineNullTest() {
        inputLineNullOrEmptyValidateTest(null);
    }

    @Test
    public void inputLineEmptyTest() {
        inputLineNullOrEmptyValidateTest("");
    }


    @Test
    public void romanCOccurrenceValidTest() {
        RomanNumeralCOccurrenceValidator validator = new RomanNumeralCOccurrenceValidator();
        ValidationResult result = validator.validate("C");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

        result = validator.validate("CC");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

        result = validator.validate("CCC");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());
    }

    @Test
    public void romanCOccurrenceInvalidTest() {
        RomanNumeralCOccurrenceValidator validator = new RomanNumeralCOccurrenceValidator();
        ValidationResult result = validator.validate("CCCC");
        Assert.assertEquals(ValidationStatus.INVALID, result.getStatus());
    }


    @Test
    public void romanDOccurrenceValidTest() {
        RomanNumeralDOccurrenceValidator validator = new RomanNumeralDOccurrenceValidator();
        ValidationResult result = validator.validate("D");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());
    }

    @Test
    public void romanDOccurrenceInvalidTest() {
        RomanNumeralDOccurrenceValidator validator = new RomanNumeralDOccurrenceValidator();
        ValidationResult result = validator.validate("DD");
        Assert.assertEquals(ValidationStatus.INVALID, result.getStatus());
    }

    @Test
    public void romanIOccurrenceValidTest() {
        RomanNumeralIOccurrenceValidator validator = new RomanNumeralIOccurrenceValidator();
        ValidationResult result = validator.validate("I");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

        result = validator.validate("II");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

        result = validator.validate("III");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

    }

    @Test
    public void romanIOccurrenceInvalidTest() {
        RomanNumeralIOccurrenceValidator validator = new RomanNumeralIOccurrenceValidator();
        ValidationResult result = validator.validate("IIII");
        Assert.assertEquals(ValidationStatus.INVALID, result.getStatus());
    }


    @Test
    public void romanLOccurrenceValidTest() {
        RomanNumeralLOccurrenceValidator validator = new RomanNumeralLOccurrenceValidator();
        ValidationResult result = validator.validate("L");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());
    }

    @Test
    public void romanLOccurrenceInvalidTest() {
        RomanNumeralLOccurrenceValidator validator = new RomanNumeralLOccurrenceValidator();
        ValidationResult result = validator.validate("LL");
        Assert.assertEquals(ValidationStatus.INVALID, result.getStatus());
    }

    @Test
    public void romanMOccurrenceValidTest() {
        RomanNumeralMOccurrenceValidator validator = new RomanNumeralMOccurrenceValidator();
        ValidationResult result = validator.validate("M");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

        result = validator.validate("MM");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

        result = validator.validate("MMM");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());
    }

    @Test
    public void romanMOccurrenceInvalidTest() {
        RomanNumeralMOccurrenceValidator validator = new RomanNumeralMOccurrenceValidator();
        ValidationResult result = validator.validate("MMMM");
        Assert.assertEquals(ValidationStatus.INVALID, result.getStatus());
    }

    @Test
    public void romanVOccurrenceValidTest() {
        RomanNumeralVOccurrenceValidator validator = new RomanNumeralVOccurrenceValidator();
        ValidationResult result = validator.validate("V");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());
    }

    @Test
    public void romanVOccurrenceInvalidTest() {
        RomanNumeralVOccurrenceValidator validator = new RomanNumeralVOccurrenceValidator();
        ValidationResult result = validator.validate("VV");
        Assert.assertEquals(ValidationStatus.INVALID, result.getStatus());
    }

    @Test
    public void romanXOccurrenceValidTest() {
        RomanNumeralXOccurrenceValidator validator = new RomanNumeralXOccurrenceValidator();
        ValidationResult result = validator.validate("X");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

        result = validator.validate("XX");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());

        result = validator.validate("XXX");
        Assert.assertEquals(ValidationStatus.VALID, result.getStatus());
    }

    @Test
    public void romanXOccurrenceInvalidTest() {
        RomanNumeralXOccurrenceValidator validator = new RomanNumeralXOccurrenceValidator();
        ValidationResult result = validator.validate("XXXX");
        Assert.assertEquals(ValidationStatus.INVALID, result.getStatus());
    }

    private void inputLineNullOrEmptyValidateTest(String input) {

        ValidatorBase validator = new RomanCPlacementValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanIPlacementValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumberValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralsOrderValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralSymbolValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanXPlacementValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralCOccurrenceValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralDOccurrenceValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralIOccurrenceValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralLOccurrenceValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralMOccurrenceValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralVOccurrenceValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumeralXOccurrenceValidator();
        assertInvalidResultNull(input, validator);

        validator = new RomanNumberValidator();
        assertInvalidResultNull(input, validator);

        validator = new UniqueSymbolValidator();
        assertInvalidResultNull(input, validator);

        validator = new UnitTokenValidator();
        assertInvalidResultNull(input, validator);

    }

    private void assertInvalidResultNull(String input, ValidatorBase validator) {
        ValidationResult result = validator.validate(input);
        Assert.assertEquals(ValidationStatus.INVALID, result.getStatus());
    }


}
