package io.github.thatyane.passwordvalidator.domain.service.steps;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HasMinLenght extends PasswordValidatorStep {

    private static final Integer SPECIAL_CHARS = 9;

    @Override
    public boolean validate(String password) {
        boolean result = password != null && password.length() >= SPECIAL_CHARS;
        log.info("The password has minimum length: {}", result);
        return result && validateNext(password);
    }
}
