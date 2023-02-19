package main.converters;

import main.enums.RomanSymbols;
import java.security.InvalidParameterException;

/**
 * Class responsible for receiving a romanNumber in form "IV..." and converting it to a valid corresponding integer
 */
public class RomanToIntegerConverter {

    /**
     * Converts recursively the value of a roman numeral string
     * @param romanNumber - roman number as string
     * @return int - a valid integer result of conversion from roman numeral to decimal
     */
    public int convertRomanToInteger(String romanNumber) {

        if(romanNumber.isEmpty()) return 0;

        if (romanNumber.startsWith("M")) return RomanSymbols.M.getIntegerValue() +
                convertRomanToInteger(romanNumber.substring(1));

        if (romanNumber.startsWith("CM")) return (RomanSymbols.M.getIntegerValue() - RomanSymbols.C.getIntegerValue()) +
                convertRomanToInteger(romanNumber.substring(2));

        if (romanNumber.startsWith("D")) return RomanSymbols.D.getIntegerValue()
                + convertRomanToInteger(romanNumber.substring(1));

        if (romanNumber.startsWith("CD")) return (RomanSymbols.D.getIntegerValue() - RomanSymbols.C.getIntegerValue()) +
                convertRomanToInteger(romanNumber.substring(2));

        if (romanNumber.startsWith("C"))
            return RomanSymbols.C.getIntegerValue() +
                    convertRomanToInteger(romanNumber.substring(1));

        if (romanNumber.startsWith("XC")) return (RomanSymbols.C.getIntegerValue() - RomanSymbols.X.getIntegerValue()) + +
                convertRomanToInteger(romanNumber.substring(2));

        if (romanNumber.startsWith("L"))
            return RomanSymbols.L.getIntegerValue() +
                    convertRomanToInteger(romanNumber.substring(1));

        if (romanNumber.startsWith("XL")) return (RomanSymbols.L.getIntegerValue() - RomanSymbols.X.getIntegerValue()) + +
                convertRomanToInteger(romanNumber.substring(2));

        if (romanNumber.startsWith("X"))
            return RomanSymbols.X.getIntegerValue() +
                    convertRomanToInteger(romanNumber.substring(1));

        if (romanNumber.startsWith("IX")) return (RomanSymbols.X.getIntegerValue() - RomanSymbols.I.getIntegerValue()) + +
                convertRomanToInteger(romanNumber.substring(2));

        if (romanNumber.startsWith("V"))
            return RomanSymbols.V.getIntegerValue() +
                    convertRomanToInteger(romanNumber.substring(1));

        if (romanNumber.startsWith("IV")) return (RomanSymbols.V.getIntegerValue() - RomanSymbols.I.getIntegerValue()) + +
                convertRomanToInteger(romanNumber.substring(2));

        if (romanNumber.startsWith("I"))
            return RomanSymbols.I.getIntegerValue() +
                    convertRomanToInteger(romanNumber.substring(1));

        throw new InvalidParameterException("Invalid roman number");

    }


}
