package com.example.securityv2.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.service.FacultyService;
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

@ContextConfiguration(classes = {FacultyController.class})
@ExtendWith(SpringExtension.class)
class FacultyControllerTest {
    @Autowired
    private FacultyController facultyController;

    @MockBean
    private FacultyService facultyService;

    @MockBean
    private InstituteService instituteService;

    /**
     * Method under test: {@link FacultyController#saveFaculty(InstituteToFaculty)}
     */
    @Test
    void testSaveFaculty() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        when(this.instituteService.getInstitute((String) any())).thenReturn(institute);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute1);
        faculty.setName("Name");
        doNothing().when(this.facultyService).setInstituteToFaculty((String) any(), (String) any());
        when(this.facultyService.saveFaculty((Faculty) any())).thenReturn(faculty);

        Institute institute2 = new Institute();
        institute2.setId(123L);
        institute2.setName("Name");

        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(institute2);
        faculty1.setName("Name");

        InstituteToFaculty instituteToFaculty = new InstituteToFaculty();
        instituteToFaculty.setFaculty(faculty1);
        instituteToFaculty.setInstituteName("Institute Name");
        String content = (new ObjectMapper()).writeValueAsString(instituteToFaculty);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/faculty/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\":\"Name\"}}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/Faculty/save"));
    }

    /**
     * Method under test: {@link FacultyController#updateFaculty(Faculty)}
     */
    @Test
    void testUpdateFaculty() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        when(this.facultyService.updateFaculty((Faculty) any())).thenReturn(faculty);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");

        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(institute1);
        faculty1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(faculty1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/faculty/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\":\"Name\"}}"));
    }

    /**
     * Method under test: {@link FacultyController#deleteFaculty(Long)}
     */
    @Test
    void testDeleteFaculty() throws Exception {
        doNothing().when(this.facultyService).deleteFaculty((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/faculty/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link FacultyController#deleteFaculty(Long)}
     */
    @Test
    void testDeleteFaculty2() throws Exception {
        doNothing().when(this.facultyService).deleteFaculty((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/faculty/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link FacultyController#getFaculties()}
     */
    @Test
    void testGetFaculties() throws Exception {
        when(this.facultyService.getFaculty()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/faculties");
        MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FacultyController#getFaculties()}
     */
    @Test
    void testGetFaculties2() throws Exception {
        when(this.facultyService.getFaculty()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/faculties");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FacultyController#getFacultyByInstitute(String)}
     */
    @Test
    void testGetFacultyByInstitute() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/faculty/find").param("name", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link FacultyController#getFacultyByName(String)}
     */
    @Test
    void testGetFacultyByName() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        when(this.facultyService.getFaculty((String) any())).thenReturn(faculty);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/faculty/find/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\":\"Name\"}}"));
    }

    /**
     * Method under test: {@link FacultyController#getFacultyByName(String)}
     */
    @Test
    void testGetFacultyByName2() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        when(this.facultyService.getFaculty((String) any())).thenReturn(faculty);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/faculty/find/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.facultyController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\":\"Name\"}}"));
    }
}

