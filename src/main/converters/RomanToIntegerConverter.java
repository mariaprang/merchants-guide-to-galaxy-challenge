package main.converters;

import main.enums.RomanSymbols;

import java.security.InvalidParameterException;

public class RomanToIntegerConverter {

    public int convertRomanToArabic(String romanNumber) {

        if(romanNumber.isEmpty()) return 0;

        if (romanNumber.startsWith("M")) return RomanSymbols.M.getIntegerValue() +
                convertRomanToArabic(romanNumber.substring(1));

        if (romanNumber.startsWith("CM")) return (RomanSymbols.M.getIntegerValue() - RomanSymbols.C.getIntegerValue()) +
                convertRomanToArabic(romanNumber.substring(2));

        if (romanNumber.startsWith("D")) return RomanSymbols.D.getIntegerValue()
                + convertRomanToArabic(romanNumber.substring(1));

        if (romanNumber.startsWith("CD")) return (RomanSymbols.D.getIntegerValue() - RomanSymbols.C.getIntegerValue()) +
                convertRomanToArabic(romanNumber.substring(2));

        if (romanNumber.startsWith("C"))
            return RomanSymbols.C.getIntegerValue() +
                    convertRomanToArabic(romanNumber.substring(1));

        if (romanNumber.startsWith("XC")) return (RomanSymbols.C.getIntegerValue() - RomanSymbols.X.getIntegerValue()) + +
                convertRomanToArabic(romanNumber.substring(2));

        if (romanNumber.startsWith("L"))
            return RomanSymbols.L.getIntegerValue() +
                    convertRomanToArabic(romanNumber.substring(1));

        if (romanNumber.startsWith("XL")) return (RomanSymbols.L.getIntegerValue() - RomanSymbols.X.getIntegerValue()) + +
                convertRomanToArabic(romanNumber.substring(2));

        if (romanNumber.startsWith("X"))
            return RomanSymbols.X.getIntegerValue() +
                    convertRomanToArabic(romanNumber.substring(1));

        if (romanNumber.startsWith("IX")) return (RomanSymbols.X.getIntegerValue() - RomanSymbols.I.getIntegerValue()) + +
                convertRomanToArabic(romanNumber.substring(2));

        if (romanNumber.startsWith("V"))
            return RomanSymbols.V.getIntegerValue() +
                    convertRomanToArabic(romanNumber.substring(1));

        if (romanNumber.startsWith("IV")) return (RomanSymbols.V.getIntegerValue() - RomanSymbols.I.getIntegerValue()) + +
                convertRomanToArabic(romanNumber.substring(2));

        if (romanNumber.startsWith("I"))
            return RomanSymbols.I.getIntegerValue() +
                    convertRomanToArabic(romanNumber.substring(1));

        throw new InvalidParameterException("Invalid roman number");

    }


}
