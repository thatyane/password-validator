package io.github.thatyane.passwordvalidator.domain.model;

import io.github.thatyane.passwordvalidator.domain.service.RegexValidator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;


@AllArgsConstructor
@EqualsAndHashCode
public class Password implements RegexValidator {

    private static final Integer LENGTH = 9;
    public static final String SPECIAL_CHARS = "!@#$%^&*()\\-+";
    private static final String REGEX_SPECIAL_CHARS = "[".concat(SPECIAL_CHARS).concat("]");

    private final String value;

    public boolean hasAtLeastNineChar() {
        return this.value.length() >= LENGTH;
    }

    public boolean hasUpperCase() {
        return match("[A-Z]", this.value);
    }

    public boolean hasDigit() {
        return match("\\d", this.value);
    }

    public boolean hasLowerCase() {
        return match("[a-z]", this.value);
    }

    public boolean hasSpecialChar() {
        return match(REGEX_SPECIAL_CHARS, this.value);
    }

    public boolean hasNoRepetedChar() {
        StringBuilder read = new StringBuilder();
        for (int i = 0; i < this.value.length(); i++) {
            char charAt = this.value.charAt(i);
            if(read.toString().indexOf(charAt) != -1){
                return false;
            }
            read.append(charAt);
        }
        return true;
    }

    public boolean hasNoSpace() {
        return !match("\\s", this.value);
    }
}
