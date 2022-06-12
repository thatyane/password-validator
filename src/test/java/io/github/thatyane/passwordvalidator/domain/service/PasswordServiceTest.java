package io.github.thatyane.passwordvalidator.domain.service;

import io.github.thatyane.passwordvalidator.domain.model.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class PasswordServiceTest {

    private PasswordService passwordService;

    @BeforeEach
    public void setUp() {
        passwordService = new PasswordService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AbTp9!fok", "Ab@p7!fok", "AbTp9#fokyZ", "$bTp91fok", "AbTp9cru%", "AbTO9penciL^", "ZibTp958&",
            "CarTp*8Gi10WF", "BcYp9(lfS25", "HcBRp6)mQU", "iByp658-Rg0", "Knvpx+fog7", "Celas@!%978"})
    void success(String value) {

        Assertions.assertTrue(passwordService.isValid(new Password(value)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"AbTp9_fok", "AbTp9|fok", "AbTp9.fok", "AbTp9,fok", "AbTp9:fok", "AbTp9;fok",
            "AbT?p98fok", "AbT}p98fok", "AbT{p98fok", "AbT]p98fok", "AbT[p98fok", "AbTxp98~ok", "AbT´p98fok", "AbT=p98fok"})
    void failedWithoutSpecialChars(String value) {

        Assertions.assertFalse(passwordService.isValid(new Password(value)));
    }

    @Test
    void failedWithoutDigit() {

        Assertions.assertFalse(passwordService.isValid(new Password("QAScvf$&D")));
    }

    @Test
    void failedWithoutUpperCase() {

        Assertions.assertFalse(passwordService.isValid(new Password("qw$7tyufg")));
    }

    @Test
    void failedWithoutLowerCase() {

        Assertions.assertFalse(passwordService.isValid(new Password("QAZXSWE12%")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"AbTp9!fok ", "AbT 9!fok", " AbTp9!fok"})
    void failedWithSpaces(String value) {

        Assertions.assertFalse(passwordService.isValid(new Password(value)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "ab", "A#1", "a+C9", "6b$De", "q7Ert!",  "YuI5pA%", "sDfgHj#6"})
    void failedWithoutMinLenght(String value) {

        Assertions.assertFalse(passwordService.isValid(new Password(value)));
    }
}