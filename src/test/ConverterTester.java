package test;

import main.converters.RomanToIntegerConverter;
import main.enums.RomanSymbols;
import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

public class ConverterTester {


    @Test
    public void romanNumberToIntegerConvertValidTest() {
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        int integerValue = converter.convertRomanToInteger("I");
        Assert.assertEquals(RomanSymbols.I.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("V");
        Assert.assertEquals(RomanSymbols.V.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("X");
        Assert.assertEquals(RomanSymbols.X.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("L");
        Assert.assertEquals(RomanSymbols.L.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("C");
        Assert.assertEquals(RomanSymbols.C.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("D");
        Assert.assertEquals(RomanSymbols.D.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("M");
        Assert.assertEquals(RomanSymbols.M.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("CM");
        Assert.assertEquals(RomanSymbols.M.getIntegerValue() - RomanSymbols.C.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("CD");
        Assert.assertEquals(RomanSymbols.D.getIntegerValue() - RomanSymbols.C.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("XC");
        Assert.assertEquals(RomanSymbols.C.getIntegerValue() - RomanSymbols.X.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("XL");
        Assert.assertEquals(RomanSymbols.L.getIntegerValue() - RomanSymbols.X.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("IX");
        Assert.assertEquals(RomanSymbols.X.getIntegerValue() - RomanSymbols.I.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("IV");
        Assert.assertEquals(RomanSymbols.V.getIntegerValue() - RomanSymbols.I.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToInteger("MCMXLIV");
        Assert.assertEquals(1944, integerValue);

        integerValue = converter.convertRomanToInteger("CLV");
        Assert.assertEquals(155, integerValue);

        integerValue = converter.convertRomanToInteger("MCCLXXV");
        Assert.assertEquals(1275, integerValue);
    }

    @Test(expected = InvalidParameterException.class)
    public void romanNumberToIntegerConvertInvalidTest() {
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        converter.convertRomanToInteger("ABC");
    }


}
