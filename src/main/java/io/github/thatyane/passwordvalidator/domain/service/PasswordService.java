package io.github.thatyane.passwordvalidator.domain.service;

import io.github.thatyane.passwordvalidator.domain.model.Password;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public boolean isValid(Password password) {

        return password.hasNoSpace() &&
                password.hasAtLeastNineChar() &&
                password.hasDigit() &&
                password.hasUpperCase() &&
                password.hasLowerCase() &&
                password.hasSpecialChar() &&
                password.hasNoRepetedChar();
    }
}
