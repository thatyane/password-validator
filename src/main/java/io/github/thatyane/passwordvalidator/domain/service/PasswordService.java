package io.github.thatyane.passwordvalidator.domain.service;

import io.github.thatyane.passwordvalidator.domain.service.steps.PasswordValidatorStep;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public boolean isValid(String password, PasswordValidatorStep passwordValidatorStep) {

        return passwordValidatorStep.validate(password);
    }
}
