package com.wjoansah.design_patterns.template.validation;

import java.util.regex.Pattern;

public class PhoneValidator extends DataValidator {
    private static final String PHONE_PATTERN = "^\\+?[0-9]{10,13}$";  // Example pattern for international phone numbers
    private static final Pattern pattern = Pattern.compile(PHONE_PATTERN);

    @Override
    protected boolean isValidFormat(String data) {
        return pattern.matcher(data).matches();
    }
}
