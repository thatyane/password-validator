package io.github.thatyane.passwordvalidator.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.thatyane.passwordvalidator.application.dto.PasswordRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static io.github.thatyane.passwordvalidator.application.controller.PasswordController.PASSWORD_PATH;
import static io.github.thatyane.passwordvalidator.application.controller.PasswordControllerTest.FIELD_VALID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldValidateValidPassword() throws Exception {
        PasswordRequest passwordRequest = new PasswordRequest("AbTp9!fok");
        String json = new ObjectMapper().writeValueAsString(passwordRequest);

        MockHttpServletRequestBuilder request = post(PASSWORD_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath(FIELD_VALID).exists())
                .andExpect(jsonPath(FIELD_VALID).value(Boolean.TRUE));
    }

    @Test
    public void shouldValidateInvalidPassword() throws Exception {
        PasswordRequest passwordRequest = new PasswordRequest("p9!fok");
        String json = new ObjectMapper().writeValueAsString(passwordRequest);

        MockHttpServletRequestBuilder request = post(PASSWORD_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath(FIELD_VALID).exists())
                .andExpect(jsonPath(FIELD_VALID).value(Boolean.FALSE));
    }
}
