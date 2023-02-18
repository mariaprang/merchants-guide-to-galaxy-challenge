package main.workflow;

import main.enums.MaterialTypes;
import main.enums.RomanSymbols;

import java.util.HashMap;
import java.util.Map;

public class MapManager {

    private static MapManager mapManager = new MapManager();
    // glob -> A
    private Map<String, RomanSymbols> unitToRomanNumeralMap;
    // Silver - 10
    private Map<MaterialTypes, Integer> commodityToCreditMap;

    private Map<String, Integer> creditQueryResultMap;
    private Map<String, Integer> romanNumberQueryResultMap;

    private MapManager() {
        this.unitToRomanNumeralMap = new HashMap<>();
        this.commodityToCreditMap = new HashMap<>();
        this.creditQueryResultMap = new HashMap<>();
        this.romanNumberQueryResultMap = new HashMap<>();
    }

    public static MapManager getInstance() {
        return mapManager;
    }

    public void addCreditQueryEntry(String romanNumeralFromQuery, Integer result) {
        creditQueryResultMap.put(romanNumeralFromQuery, result);
    }

    public void addRomanNumberQueryEntry(String romanNumeralFromQuery, Integer result) {
        romanNumberQueryResultMap.put(romanNumeralFromQuery, result);
    }


    public String getCreditQueryResultMapAsString() {
        String result = "";
        for (Map.Entry<String, Integer> entry : creditQueryResultMap.entrySet()) {
            result += entry.getKey() + " is " + entry.getValue() + " Credits\n";
        }
        return result;
    }

    public String getRomanNumberQueryResultMapAsString() {
        String result = "";
        for (Map.Entry<String, Integer> entry : romanNumberQueryResultMap.entrySet()) {
            result += entry.getKey() + " is " + entry.getValue();
        }
        return result;
    }

    public int getIntegerResultFromRomanNumeral(String romanNumber){
        return romanNumberQueryResultMap.get(romanNumber);
    }

    public int getCreditValueFromRomanvNumeral(String romanNumber){
        return creditQueryResultMap.get(romanNumber);
    }

    public void addUnitToRomanNumeralEntry(String key, RomanSymbols value) {
        unitToRomanNumeralMap.put(key, value);
    }

    public void addCommodityToCreditEntry(MaterialTypes key, Integer value) {
        commodityToCreditMap.put(key, value);
    }

    public Map<MaterialTypes, Integer> getCommodityToCreditMap() {
        return commodityToCreditMap;
    }

    public Map<String, RomanSymbols> getUnitToRomanNumeralMap() {
        return unitToRomanNumeralMap;
    }

    public RomanSymbols getRomanNumeralByUnit(String unit) {
        return unitToRomanNumeralMap.get(unit);
    }

    public Integer getCreditByCommodity(MaterialTypes commodity) {
        return commodityToCreditMap.get(commodity);
    }
}
