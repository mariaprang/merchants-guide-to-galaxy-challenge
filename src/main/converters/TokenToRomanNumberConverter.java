package main.converters;

import main.enums.RomanSymbols;
import main.inputKeywords.InputKeywords;

import main.workflow.MapManager;

public class TokenToRomanNumberConverter {

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
