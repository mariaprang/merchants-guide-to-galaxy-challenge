package main.converters;

import main.enums.RomanSymbols;
import main.inputKeywords.InputKeywords;

import main.workflow.MapManager;

/**
 * Class responsible for converting single or multiple unit tokens,
 * such as "glob" or "pish" to corresponding roman numerals
 */
public class TokenToRomanNumberConverter {

    /**
     * Converts the unitToken entry to a roman number based on a mapping done by MapperParser parser class and saved
     * in the MapManager class.
     * @param unitTokenInput - unit token as either single or multiple units, such as "glob" or "pish"
     * @return a String corresponding to a valid roman number
     */
    public static String convertToRomanNumber(String unitTokenInput) {
        MapManager mapManager = MapManager.getInstance();
        String[] tokens = unitTokenInput.split(InputKeywords.DELIMITER);
        String romanNumber = "";
        for (String token : tokens) {
            RomanSymbols romanNumeral = mapManager.getRomanNumeralByUnit(token);
            romanNumber += romanNumeral;
        }
        return romanNumber;
    }

}
