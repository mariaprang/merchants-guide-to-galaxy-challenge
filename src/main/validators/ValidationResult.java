package main.validators;

import main.enums.ValidationStatus;

/**
 * Class representing a result from validation method. Contains its status and an error message, if any
 */
public class ValidationResult {

    private ValidationStatus status;
    private String message;

    public ValidationResult(ValidationStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
