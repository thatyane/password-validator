package io.github.thatyane.passwordvalidator.application.controller;

import io.github.thatyane.passwordvalidator.application.dto.PasswordRequest;
import io.github.thatyane.passwordvalidator.application.dto.PasswordResponse;
import io.github.thatyane.passwordvalidator.domain.service.PasswordService;
import io.github.thatyane.passwordvalidator.domain.service.steps.PasswordCatalog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class PasswordController implements PasswordControllerDoc {

    public static final String PASSWORD_PATH = "/passwords/validation";

    private final PasswordService passwordService;

    @Override
    @PostMapping(value = PASSWORD_PATH)
    public PasswordResponse isValid(@RequestBody PasswordRequest passwordRequest) {
        log.info("Validating password: {}", passwordRequest.getPassword());
        boolean isValid = passwordService.isValid(passwordRequest.getPassword(), PasswordCatalog.validatePassword);
        log.info("The password is {}", isValid ? "valid" : "invalid");
        return new PasswordResponse(isValid);
    }
}
