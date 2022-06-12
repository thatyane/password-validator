package io.github.thatyane.passwordvalidator.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.thatyane.passwordvalidator.application.dto.PasswordRequest;
import io.github.thatyane.passwordvalidator.domain.model.Password;
import io.github.thatyane.passwordvalidator.domain.service.PasswordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static io.github.thatyane.passwordvalidator.application.controller.PasswordController.PASSWORD_PATH;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PasswordController.class)
@AutoConfigureMockMvc
class PasswordControllerTest {

    public static final String FIELD_VALID = "$.valid";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordService passwordService;

    @Test
    public void shouldValidateValidPassword() throws Exception {
        PasswordRequest passwordRequest = new PasswordRequest("AbTp9!fok");
        Password password = new Password(passwordRequest.getPassword());
        String json = new ObjectMapper().writeValueAsString(passwordRequest);

        when(passwordService.isValid(password)).thenReturn(Boolean.TRUE);

        MockHttpServletRequestBuilder request = post(PASSWORD_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath(FIELD_VALID).exists())
                .andExpect(jsonPath(FIELD_VALID).value(Boolean.TRUE));

        verify(passwordService).isValid(password);
    }

    @Test
    public void shouldValidateInvalidPassword() throws Exception {
        PasswordRequest passwordRequest = new PasswordRequest("p9!fok");
        Password password = new Password(passwordRequest.getPassword());
        String json = new ObjectMapper().writeValueAsString(passwordRequest);

        when(passwordService.isValid(password)).thenReturn(Boolean.FALSE);

        MockHttpServletRequestBuilder request = post(PASSWORD_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath(FIELD_VALID).exists())
                .andExpect(jsonPath(FIELD_VALID).value(Boolean.FALSE));

        verify(passwordService).isValid(password);
    }
}