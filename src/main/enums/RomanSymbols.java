package main.enums;


public enum RomanSymbols {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int arabicValue;

    private RomanSymbols(int arabicValue) {
        this.arabicValue = arabicValue;
    }

    public String getRomanNumeral() {
        return this.toString();
    }

}

