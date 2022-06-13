package com.example.securityv2.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Institute;
import com.example.securityv2.service.InstituteService;
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

@ContextConfiguration(classes = {InstituteController.class})
@ExtendWith(SpringExtension.class)
class InstituteControllerTest {
    @Autowired
    private InstituteController instituteController;

    @MockBean
    private InstituteService instituteService;

    /**
     * Method under test: {@link InstituteController#saveInstitute(Institute)}
     */
    @Test
    void testSaveInstitute() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        when(this.instituteService.saveInstitute((Institute) any())).thenReturn(institute);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(institute1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/institute/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.instituteController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/institute/save"));
    }

    /**
     * Method under test: {@link InstituteController#updateInstitute(Institute)}
     */
    @Test
    void testUpdateInstitute() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        when(this.instituteService.updateInstitute((Institute) any())).thenReturn(institute);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(institute1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/institute/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.instituteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link InstituteController#deleteInstitute(Long)}
     */
    @Test
    void testDeleteInstitute() throws Exception {
        doNothing().when(this.instituteService).deleteInstitute((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/institute/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.instituteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link InstituteController#deleteInstitute(Long)}
     */
    @Test
    void testDeleteInstitute2() throws Exception {
        doNothing().when(this.instituteService).deleteInstitute((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/institute/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.instituteController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link InstituteController#getFaculties()}
     */
    @Test
    void testGetFaculties() throws Exception {
        when(this.instituteService.getInstitute()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/institutes");
        MockMvcBuilders.standaloneSetup(this.instituteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link InstituteController#getFaculties()}
     */
    @Test
    void testGetFaculties2() throws Exception {
        when(this.instituteService.getInstitute()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/institutes");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.instituteController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link InstituteController#getInstituteByName(String)}
     */
    @Test
    void testGetInstituteByName() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        when(this.instituteService.getInstitute((String) any())).thenReturn(institute);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/institute/find/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.instituteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link InstituteController#getInstituteByName(String)}
     */
    @Test
    void testGetInstituteByName2() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        when(this.instituteService.getInstitute((String) any())).thenReturn(institute);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/institute/find/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.instituteController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }
}

