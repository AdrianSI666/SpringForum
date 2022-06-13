package com.example.securityv2.registration;

import com.example.securityv2.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RegistrationController.class})
@ExtendWith(SpringExtension.class)
class RegistrationControllerTest {
    @Autowired
    private RegistrationController registrationController;

    @MockBean
    private RegistrationService registrationService;

    /**
     * Method under test: {@link RegistrationController#confirm(String)}
     */
    @Test
    void testConfirm() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/confirm").param("token", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.registrationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link RegistrationController#register(RegistrationRequest)}
     */
    @Test
    void testRegister() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new RegistrationRequest("Nickname", "jane.doe@example.org", "iloveyou",
                        1, "Icon", "The characteristics of someone or something")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.registrationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link RegistrationController#resend(User)}
     */
    @Test
    void testResend() throws Exception {
        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/resend")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.registrationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

