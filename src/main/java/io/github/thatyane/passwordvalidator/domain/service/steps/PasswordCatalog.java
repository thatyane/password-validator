package io.github.thatyane.passwordvalidator.domain.service.steps;

public class PasswordCatalog {

    public static PasswordValidatorStep validatePassword = buildChain(
            new HasMinLenght(), new HasNoSpace(), new HasDigit(), new HasUpperCase(),
            new HasLowerCase(), new HasSpecialChar(), new HasNoRepetedChar());

    private static PasswordValidatorStep buildChain(PasswordValidatorStep... steps) {
        for (int index = 0; index < steps.length - 1; index++) {
            PasswordValidatorStep currentStep = steps[index];
            currentStep.setNextStep(steps[index + 1]);
        }
        return steps[0];
    }
}
