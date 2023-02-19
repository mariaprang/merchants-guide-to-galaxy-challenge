package main.enums;

/**
 * Enumeration containing all of the valid roman symbols.
 * Other symbols are not accepted in the parsers
 */
public enum RomanSymbols {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int integerValue;

    private RomanSymbols(int integerValue) {
        this.integerValue = integerValue;
    }

    public String getRomanNumeral() {
        return this.toString();
    }

    public int getIntegerValue() {
        return integerValue;
    }
}

