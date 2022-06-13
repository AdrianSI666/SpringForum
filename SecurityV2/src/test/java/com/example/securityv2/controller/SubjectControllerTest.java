package com.example.securityv2.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Year;
import com.example.securityv2.service.SubjectService;
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

@ContextConfiguration(classes = {SubjectController.class})
@ExtendWith(SpringExtension.class)
class SubjectControllerTest {
    @Autowired
    private SubjectController subjectController;

    @MockBean
    private SubjectService subjectService;

    /**
     * Method under test: {@link SubjectController#saveSubject(YearToSubject)}
     */
    @Test
    void testSaveSubject() throws Exception {
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

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setYear(year);
        doNothing().when(this.subjectService).setYearToSubject((String) any(), (String) any());
        when(this.subjectService.saveSubject((Subject) any())).thenReturn(subject);

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

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setYear(year1);

        YearToSubject yearToSubject = new YearToSubject();
        yearToSubject.setSubject(subject1);
        yearToSubject.setYearName("Year Name");
        String content = (new ObjectMapper()).writeValueAsString(yearToSubject);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/subject/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"year\":{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\""
                                        + ":{\"id\":123,\"name\":\"Name\"}}}}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/subject/save"));
    }

    /**
     * Method under test: {@link SubjectController#updateSubject(Subject)}
     */
    @Test
    void testUpdateSubject() throws Exception {
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

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setYear(year);
        when(this.subjectService.updateSubject((Subject) any())).thenReturn(subject);

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

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setYear(year1);
        String content = (new ObjectMapper()).writeValueAsString(subject1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/subject/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"year\":{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\""
                                        + ":{\"id\":123,\"name\":\"Name\"}}}}"));
    }

    /**
     * Method under test: {@link SubjectController#deleteSubject(Long)}
     */
    @Test
    void testDeleteSubject() throws Exception {
        doNothing().when(this.subjectService).deleteSubject((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/subject/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link SubjectController#deleteSubject(Long)}
     */
    @Test
    void testDeleteSubject2() throws Exception {
        doNothing().when(this.subjectService).deleteSubject((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/subject/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link SubjectController#getFaculties()}
     */
    @Test
    void testGetFaculties() throws Exception {
        when(this.subjectService.getSubject()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/subjects");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link SubjectController#getFaculties()}
     */
    @Test
    void testGetFaculties2() throws Exception {
        when(this.subjectService.getSubject()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/subjects");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link SubjectController#getSubjectByName(String)}
     */
    @Test
    void testGetSubjectByName() throws Exception {
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

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setYear(year);
        when(this.subjectService.getSubject((String) any())).thenReturn(subject);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/subject/find/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"year\":{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\""
                                        + ":{\"id\":123,\"name\":\"Name\"}}}}"));
    }

    /**
     * Method under test: {@link SubjectController#getSubjectByName(String)}
     */
    @Test
    void testGetSubjectByName2() throws Exception {
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

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setYear(year);
        when(this.subjectService.getSubject((String) any())).thenReturn(subject);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/subject/find/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"year\":{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\""
                                        + ":{\"id\":123,\"name\":\"Name\"}}}}"));
    }

    /**
     * Method under test: {@link SubjectController#getSubjectByYear(String)}
     */
    @Test
    void testGetSubjectByYear() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/subject/find").param("name", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.subjectController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

