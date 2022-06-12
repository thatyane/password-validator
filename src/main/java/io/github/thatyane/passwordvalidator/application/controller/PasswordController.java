package io.github.thatyane.passwordvalidator.application.controller;

import io.github.thatyane.passwordvalidator.application.dto.PasswordRequest;
import io.github.thatyane.passwordvalidator.application.dto.PasswordResponse;
import io.github.thatyane.passwordvalidator.domain.model.Password;
import io.github.thatyane.passwordvalidator.domain.service.PasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class PasswordController {

    public static final String PASSWORD_PATH = "/passwords/validation";

    private final PasswordService passwordService;

    @PostMapping(value = PASSWORD_PATH)
    public PasswordResponse isValid(@RequestBody PasswordRequest passwordRequest) {
        log.info("Validating this password: {}", passwordRequest.getPassword());

        boolean isValid = passwordService.isValid(new Password(passwordRequest.getPassword()));

        return new PasswordResponse(isValid);
    }
}
