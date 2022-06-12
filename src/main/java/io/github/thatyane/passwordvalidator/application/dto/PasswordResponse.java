package io.github.thatyane.passwordvalidator.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PasswordResponse {

    private final boolean isValid;
}
