package io.github.thatyane.passwordvalidator.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordRequest {

    @Size(min = 9)
    @NotNull
    private String password;
}
