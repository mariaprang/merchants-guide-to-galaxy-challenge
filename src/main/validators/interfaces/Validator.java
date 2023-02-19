package main.validators.interfaces;

import main.enums.InputTypes;
import main.enums.RomanSymbols;
import main.validators.ValidationResult;

import java.util.List;

/**
 * Validator interface implemented in all of the validators.
 */
public interface Validator {

    /**
     * SYMBOLS: I, X, C, M, L, D, V
     * RULES:
     * 1. Occurrence:
     * --- The symbols "I", "X", "C", and "M" can be repeated three times in succession
     * --- "D", "L", and "V" can never be repeated.
     * 2. Subtraction:
     * --- "I" can be subtracted from "V" and "X" only.
     * --- "X" can be subtracted from "L" and "C" only.
     * --- "C" can be subtracted from "D" and "M" only.
     * --- "V", "L", and "D" can never be subtracted --> check by converter
     * --- Only one small-value symbol may be subtracted from any large-value symbol.
     */

    public ValidationResult validate(String inputLine);


}
