package io.github.thatyane.passwordvalidator.domain.service.steps;

public class HasNoRepetedChar extends PasswordValidatorStep {

    @Override
    public boolean validate(String password) {
        StringBuilder read = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char charAt =password.charAt(i);
            if (read.toString().indexOf(charAt) != -1) {
                return false;
            }
            read.append(charAt);
        }
        return validateNext(password);
    }
}
