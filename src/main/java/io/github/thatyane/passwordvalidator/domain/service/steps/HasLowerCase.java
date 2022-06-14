package io.github.thatyane.passwordvalidator.domain.service.steps;

import io.github.thatyane.passwordvalidator.domain.service.RegexValidator;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HasLowerCase extends PasswordValidatorStep implements RegexValidator {

    @Override
    public boolean validate(String password) {
        boolean result = match("[a-z]", password);
        log.info("The password has lower case: {}", result);
        return result && validateNext(password);
    }
}
