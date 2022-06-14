package io.github.thatyane.passwordvalidator.domain.service.steps;

import io.github.thatyane.passwordvalidator.domain.service.RegexValidator;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HasSpecialChar extends PasswordValidatorStep implements RegexValidator {

    private static final String SPECIAL_CHARS = "!@#$%^&*()\\-+";
    private static final String REGEX_SPECIAL_CHARS = "[".concat(SPECIAL_CHARS).concat("]");

    @Override
    public boolean validate(String password) {
        boolean result = match(REGEX_SPECIAL_CHARS, password);
        log.info("The password has special char: {}", result);
        return result && validateNext(password);
    }
}
