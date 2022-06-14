package io.github.thatyane.passwordvalidator.domain.service;

import io.github.thatyane.passwordvalidator.domain.service.steps.PasswordValidatorStep;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PasswordService {

    public boolean isValid(String password, PasswordValidatorStep passwordValidatorStep) {
        try {
            return passwordValidatorStep.validate(password);
        } catch (Exception e) {
            log.error("Error when validating password: {} - {}", password, e.getMessage());
            return Boolean.FALSE;
        }
    }
}
