package com.wjoansah.design_patterns.template.validation;

public abstract class DataValidator {

    // Template method defining the validation workflow
    public final boolean validate(String data) {
        if (isNull(data)) {
            System.out.println("Validation failed: data is null or empty.");
            return false;
        }

        if (!isValidFormat(data)) {
            System.out.println("Validation failed: data format is invalid.");
            return false;
        }

        return true;
    }

    // Common validation check for null or empty data
    private boolean isNull(String data) {
        return data == null || data.isEmpty();
    }

    // Abstract method for format validation, to be implemented by subclasses
    protected abstract boolean isValidFormat(String data);
}
