package io.github.thatyane.passwordvalidator.application.controller;

import io.github.thatyane.passwordvalidator.application.dto.PasswordRequest;
import io.github.thatyane.passwordvalidator.application.dto.PasswordResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

public interface PasswordControllerDoc {

    @Operation(summary = "Check if the password is valid")
    PasswordResponse isValid(@Parameter(description = "Password that needs to be validated", required = true) PasswordRequest passwordRequest);
}
