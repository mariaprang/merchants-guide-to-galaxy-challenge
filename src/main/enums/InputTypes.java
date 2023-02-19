package main.enums;

/**
 * An enumerator representing different set of types possible:
 * MAPPING, such as "glob is I"
 * COMMODITY_PRICE_INFORMATION, such as "glob glob Silver is 34 Credits"
 * ROMAN_NUMBER_QUESTION, such as "How much is "glob glob"
 * CREDIT_VALUE_QUESTION, such as "How many Credits are "pish pish Iron"
 */
public enum InputTypes {

    NONE,
    MAPPING,
    COMMODITY_PRICE_INFORMATION,
    ROMAN_NUMBER_QUESTION,
    CREDIT_VALUE_QUESTION

}
