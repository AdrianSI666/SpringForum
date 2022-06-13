package com.example.securityv2.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.domain.Year;
import com.example.securityv2.service.YearService;
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

@ContextConfiguration(classes = {YearController.class})
@ExtendWith(SpringExtension.class)
class YearControllerTest {
    @Autowired
    private YearController yearController;

    @MockBean
    private YearService yearService;

    /**
     * Method under test: {@link YearController#getYearsByFaculty(String)}
     */
    @Test
    void testGetYearsByFaculty2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/year/find").param("name", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link YearController#saveYear(FacultyToYear)}
     */
    @Test
    void testSaveYear() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        doNothing().when(this.yearService).setFacultyToYear((String) any(), (String) any());
        when(this.yearService.saveYear((Year) any())).thenReturn(year);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");

        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(institute1);
        faculty1.setName("Name");

        Year year1 = new Year();
        year1.setFaculty(faculty1);
        year1.setId(123L);
        year1.setName("Name");

        FacultyToYear facultyToYear = new FacultyToYear();
        facultyToYear.setFacultyName("Faculty Name");
        facultyToYear.setYear(year1);
        String content = (new ObjectMapper()).writeValueAsString(facultyToYear);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/year/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\":\"Name\"}}}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/year/save"));
    }

    /**
     * Method under test: {@link YearController#updateYear(Year)}
     */
    @Test
    void testUpdateYear() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        when(this.yearService.updateYear((Year) any())).thenReturn(year);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");

        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(institute1);
        faculty1.setName("Name");

        Year year1 = new Year();
        year1.setFaculty(faculty1);
        year1.setId(123L);
        year1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(year1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/year/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\":\"Name\"}}}"));
    }

    /**
     * Method under test: {@link YearController#deleteYear(Long)}
     */
    @Test
    void testDeleteYear() throws Exception {
        doNothing().when(this.yearService).deleteYear((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/year/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link YearController#deleteYear(Long)}
     */
    @Test
    void testDeleteYear2() throws Exception {
        doNothing().when(this.yearService).deleteYear((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/year/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link YearController#getFaculties()}
     */
    @Test
    void testGetFaculties() throws Exception {
        when(this.yearService.getYear()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/years");
        MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link YearController#getFaculties()}
     */
    @Test
    void testGetFaculties2() throws Exception {
        when(this.yearService.getYear()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/years");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link YearController#getYearByName(String)}
     */
    @Test
    void testGetYearByName() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        when(this.yearService.getYear((String) any())).thenReturn(year);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/year/find/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\":\"Name\"}}}"));
    }

    /**
     * Method under test: {@link YearController#getYearByName(String)}
     */
    @Test
    void testGetYearByName2() throws Exception {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        when(this.yearService.getYear((String) any())).thenReturn(year);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/year/find/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\":\"Name\"}}}"));
    }

    /**
     * Method under test: {@link YearController#getYearsByFaculty(String)}
     */
    @Test
    void testGetYearsByFaculty() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/year/find").param("name", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.yearController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

