package com.wjoansah.design_patterns.template.validation;

import java.util.regex.Pattern;

public class EmailValidator extends DataValidator {
    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    protected boolean isValidFormat(String data) {
        return pattern.matcher(data).matches();
    }
}
