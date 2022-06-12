package io.github.thatyane.passwordvalidator.domain.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface RegexValidator {

    default boolean match(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }
}
