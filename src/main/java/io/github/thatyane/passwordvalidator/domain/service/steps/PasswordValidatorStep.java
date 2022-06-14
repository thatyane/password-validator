package io.github.thatyane.passwordvalidator.domain.service.steps;

public abstract class PasswordValidatorStep {
    private PasswordValidatorStep nextStep;

    public void setNextStep(PasswordValidatorStep next) {
        this.nextStep = next;
    }

    public abstract boolean validate(String password);

    protected boolean validateNext(String password) {
        return this.nextStep == null || nextStep.validate(password);
    }
}