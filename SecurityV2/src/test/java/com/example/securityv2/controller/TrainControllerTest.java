package com.example.securityv2.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Train;
import com.example.securityv2.domain.User;
import com.example.securityv2.domain.Year;
import com.example.securityv2.service.TrainService;
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

@ContextConfiguration(classes = {TrainController.class})
@ExtendWith(SpringExtension.class)
class TrainControllerTest {
    @Autowired
    private TrainController trainController;

    @MockBean
    private TrainService trainService;

    /**
     * Method under test: {@link TrainController#saveTrain(SubjectToTrain)}
     */
    @Test
    void testSaveTrain() throws Exception {
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

        Train train = new Train();
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        doNothing().when(this.trainService).setSubjectToTrain((String) any(), (String) any());
        when(this.trainService.saveTrain((Train) any())).thenReturn(train);

        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(new Institute());
        faculty1.setName("Name");

        Year year1 = new Year();
        year1.setFaculty(faculty1);
        year1.setId(123L);
        year1.setName("Name");

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setYear(year1);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Icon");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Nickname");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());

        Train train1 = new Train();
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Name");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user1);

        SubjectToTrain subjectToTrain = new SubjectToTrain();
        subjectToTrain.setSubjectName("Hello from the Dreaming Spires");
        subjectToTrain.setTrain(train1);
        String content = (new ObjectMapper()).writeValueAsString(subjectToTrain);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/train/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"content\":\"Not all who wander are lost\",\"rate\":1,\"subject\":{\"id\":123,\"name\":"
                                        + "\"Name\",\"year\":{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\""
                                        + ":\"Name\"}}}},\"user\":{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\","
                                        + "\"description\":\"The characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[]"
                                        + ",\"badges\":[],\"locked\":true,\"enabled\":true}}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/Train/save"));
    }

    /**
     * Method under test: {@link TrainController#updateTrain(Train)}
     */
    @Test
    void testUpdateTrain() throws Exception {
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

        Train train = new Train();
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        when(this.trainService.updateTrain((Train) any())).thenReturn(train);

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

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Icon");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Nickname");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());

        Train train1 = new Train();
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Name");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user1);
        String content = (new ObjectMapper()).writeValueAsString(train1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/train/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"content\":\"Not all who wander are lost\",\"rate\":1,\"subject\":{\"id\":123,\"name\":"
                                        + "\"Name\",\"year\":{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\""
                                        + ":\"Name\"}}}},\"user\":{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\","
                                        + "\"description\":\"The characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[]"
                                        + ",\"badges\":[],\"locked\":true,\"enabled\":true}}"));
    }

    /**
     * Method under test: {@link TrainController#decrementTrainByName(String)}
     */
    @Test
    void testDecrementTrainByName() throws Exception {
        doNothing().when(this.trainService).decrementRate((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/train/decrement/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TrainController#deleteTrain(Long)}
     */
    @Test
    void testDeleteTrain() throws Exception {
        doNothing().when(this.trainService).deleteTrain((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/train/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TrainController#deleteTrain(Long)}
     */
    @Test
    void testDeleteTrain2() throws Exception {
        doNothing().when(this.trainService).deleteTrain((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/train/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TrainController#decrementTrainByName(String)}
     */
    @Test
    void testDecrementTrainByName2() throws Exception {
        doNothing().when(this.trainService).decrementRate((String) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/train/decrement/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TrainController#getFaculties()}
     */
    @Test
    void testGetFaculties() throws Exception {
        when(this.trainService.getTrain()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/trains");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TrainController#getFaculties()}
     */
    @Test
    void testGetFaculties2() throws Exception {
        when(this.trainService.getTrain()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/trains");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TrainController#getTrainByName(String)}
     */
    @Test
    void testGetTrainByName() throws Exception {
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

        Train train = new Train();
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        when(this.trainService.getTrain((String) any())).thenReturn(train);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/train/find/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"content\":\"Not all who wander are lost\",\"rate\":1,\"subject\":{\"id\":123,\"name\":"
                                        + "\"Name\",\"year\":{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\""
                                        + ":\"Name\"}}}},\"user\":{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\","
                                        + "\"description\":\"The characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[]"
                                        + ",\"badges\":[],\"locked\":true,\"enabled\":true}}"));
    }

    /**
     * Method under test: {@link TrainController#getTrainByName(String)}
     */
    @Test
    void testGetTrainByName2() throws Exception {
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

        Train train = new Train();
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        when(this.trainService.getTrain((String) any())).thenReturn(train);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/train/find/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"content\":\"Not all who wander are lost\",\"rate\":1,\"subject\":{\"id\":123,\"name\":"
                                        + "\"Name\",\"year\":{\"id\":123,\"name\":\"Name\",\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":123,\"name\""
                                        + ":\"Name\"}}}},\"user\":{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\","
                                        + "\"description\":\"The characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[]"
                                        + ",\"badges\":[],\"locked\":true,\"enabled\":true}}"));
    }

    /**
     * Method under test: {@link TrainController#getTrainBySubject(String)}
     */
    @Test
    void testGetTrainBySubject() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/train/find").param("name", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link TrainController#incrementTrainByName(String)}
     */
    @Test
    void testIncrementTrainByName() throws Exception {
        doNothing().when(this.trainService).incrementRate((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/train/increment/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TrainController#incrementTrainByName(String)}
     */
    @Test
    void testIncrementTrainByName2() throws Exception {
        doNothing().when(this.trainService).incrementRate((String) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/train/increment/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.trainController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

