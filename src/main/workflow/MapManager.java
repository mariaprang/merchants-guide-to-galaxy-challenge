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

    private MapManager() {
        this.unitToRomanNumeralMap = new HashMap<>();
        this.commodityToCreditMap = new HashMap<>();
    }

    public static MapManager getInstance(){
        return mapManager;
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

    public RomanSymbols getRomanNumeralByUnit(String unit){
        return unitToRomanNumeralMap.get(unit);
    }

    public Integer getCreditByCommodity(MaterialTypes commodity){
        return commodityToCreditMap.get(commodity);
    }
}
