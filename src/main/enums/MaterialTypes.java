package main.enums;

/**
 * Set of dfferent material types
 */
public enum MaterialTypes {

    SILVER("Silver"),
    IRON("Iron"),
    GOLD("Gold");

    private String commodityType;

    private MaterialTypes(String metalType) {
        this.commodityType = metalType;
    }

    public String getValue() {
        return commodityType;
    }

    public static MaterialTypes getMaterialByValue(String value) {
        for (MaterialTypes commodity : values()) {
            if (commodity.commodityType.equals(value)) {
                return commodity;
            }
        }
        return null;
    }
}
