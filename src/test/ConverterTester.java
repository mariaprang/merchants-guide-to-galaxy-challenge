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
        int integerValue = converter.convertRomanToArabic("I");
        Assert.assertEquals(RomanSymbols.I.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("V");
        Assert.assertEquals(RomanSymbols.V.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("X");
        Assert.assertEquals(RomanSymbols.X.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("L");
        Assert.assertEquals(RomanSymbols.L.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("C");
        Assert.assertEquals(RomanSymbols.C.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("D");
        Assert.assertEquals(RomanSymbols.D.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("M");
        Assert.assertEquals(RomanSymbols.M.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("CM");
        Assert.assertEquals(RomanSymbols.M.getIntegerValue() - RomanSymbols.C.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("CD");
        Assert.assertEquals(RomanSymbols.D.getIntegerValue() - RomanSymbols.C.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("XC");
        Assert.assertEquals(RomanSymbols.C.getIntegerValue() - RomanSymbols.X.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("XL");
        Assert.assertEquals(RomanSymbols.L.getIntegerValue() - RomanSymbols.X.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("IX");
        Assert.assertEquals(RomanSymbols.X.getIntegerValue() - RomanSymbols.I.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("IV");
        Assert.assertEquals(RomanSymbols.V.getIntegerValue() - RomanSymbols.I.getIntegerValue(), integerValue);

        integerValue = converter.convertRomanToArabic("MCMXLIV");
        Assert.assertEquals(1944, integerValue);

        integerValue = converter.convertRomanToArabic("CLV");
        Assert.assertEquals(155, integerValue);

        integerValue = converter.convertRomanToArabic("MCCLXXV");
        Assert.assertEquals(1275, integerValue);
    }

    @Test(expected = InvalidParameterException.class)
    public void romanNumberToIntegerConvertInvalidTest() {
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        converter.convertRomanToArabic("ABC");
    }


}
