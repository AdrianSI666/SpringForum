package com.example.securityv2.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Commentary;
import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Train;
import com.example.securityv2.domain.User;
import com.example.securityv2.domain.Year;
import com.example.securityv2.service.CommentaryService;
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

@ContextConfiguration(classes = {CommentaryController.class})
@ExtendWith(SpringExtension.class)
class CommentaryControllerTest {
    @Autowired
    private CommentaryController commentaryController;

    @MockBean
    private CommentaryService commentaryService;

    /**
     * Method under test: {@link CommentaryController#saveCommentary(CommentaryByUserToTrain)}
     */
    @Test
    void testSaveCommentary() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
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

        Commentary commentary = new Commentary();
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        doNothing().when(this.commentaryService).setTrianToCommentary((Long) any(), (String) any());
        doNothing().when(this.commentaryService).setUserToCommentary((Long) any(), (String) any());
        when(this.commentaryService.saveCommentary((Commentary) any())).thenReturn(commentary);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Name");

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setYear(year1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Icon");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Nickname");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());

        Train train1 = new Train();
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Name");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user2);

        User user3 = new User();
        user3.setBadges(new ArrayList<>());
        user3.setDescription("The characteristics of someone or something");
        user3.setEmail("jane.doe@example.org");
        user3.setEnabled(true);
        user3.setIcon("Icon");
        user3.setId(123L);
        user3.setIndeks(1);
        user3.setLocked(true);
        user3.setNickname("Nickname");
        user3.setPassword("iloveyou");
        user3.setRole(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(1);
        commentary1.setTrain(train1);
        commentary1.setUser(user3);

        CommentaryByUserToTrain commentaryByUserToTrain = new CommentaryByUserToTrain();
        commentaryByUserToTrain.setCommentary(commentary1);
        commentaryByUserToTrain.setTrainName("Train Name");
        commentaryByUserToTrain.setUserEmail("jane.doe@example.org");
        String content = (new ObjectMapper()).writeValueAsString(commentaryByUserToTrain);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/commentary/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"content\":\"Not all who wander are lost\",\"rate\":1,\"train\":{\"id\":123,\"name\":\"Name\",\"content\":\"Not"
                                        + " all who wander are lost\",\"rate\":1,\"subject\":{\"id\":123,\"name\":\"Name\",\"year\":{\"id\":123,\"name\":\"Name\","
                                        + "\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":null,\"name\":null}}}},\"user\":{\"id\":123,\"indeks\":1"
                                        + ",\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The characteristics of someone"
                                        + " or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked\":true,\"enabled\":true}},"
                                        + "\"user\":{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/commentary/save"));
    }

    /**
     * Method under test: {@link CommentaryController#updateCommentary(Commentary)}
     */
    @Test
    void testUpdateCommentary() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
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

        Commentary commentary = new Commentary();
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        when(this.commentaryService.updateCommentary((Commentary) any())).thenReturn(commentary);

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

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Icon");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Nickname");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());

        Train train1 = new Train();
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Name");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user2);

        User user3 = new User();
        user3.setBadges(new ArrayList<>());
        user3.setDescription("The characteristics of someone or something");
        user3.setEmail("jane.doe@example.org");
        user3.setEnabled(true);
        user3.setIcon("Icon");
        user3.setId(123L);
        user3.setIndeks(1);
        user3.setLocked(true);
        user3.setNickname("Nickname");
        user3.setPassword("iloveyou");
        user3.setRole(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(1);
        commentary1.setTrain(train1);
        commentary1.setUser(user3);
        String content = (new ObjectMapper()).writeValueAsString(commentary1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/commentary/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"content\":\"Not all who wander are lost\",\"rate\":1,\"train\":{\"id\":123,\"name\":\"Name\",\"content\":\"Not"
                                        + " all who wander are lost\",\"rate\":1,\"subject\":{\"id\":123,\"name\":\"Name\",\"year\":{\"id\":123,\"name\":\"Name\","
                                        + "\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":null,\"name\":null}}}},\"user\":{\"id\":123,\"indeks\":1"
                                        + ",\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The characteristics of someone"
                                        + " or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked\":true,\"enabled\":true}},"
                                        + "\"user\":{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}}"));
    }

    /**
     * Method under test: {@link CommentaryController#decrementCommentaryByName(Long)}
     */
    @Test
    void testDecrementCommentaryByName() throws Exception {
        doNothing().when(this.commentaryService).decrementRate((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/commentary/decrement/{name}", 1L);
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CommentaryController#deleteCommentary(Long)}
     */
    @Test
    void testDeleteCommentary() throws Exception {
        doNothing().when(this.commentaryService).deleteCommentary((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/commentary/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CommentaryController#deleteCommentary(Long)}
     */
    @Test
    void testDeleteCommentary2() throws Exception {
        doNothing().when(this.commentaryService).deleteCommentary((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/commentary/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CommentaryController#decrementCommentaryByName(Long)}
     */
    @Test
    void testDecrementCommentaryByName2() throws Exception {
        doNothing().when(this.commentaryService).decrementRate((Long) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/commentary/decrement/{name}", 1L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CommentaryController#getCommentaryById(Long)}
     */
    @Test
    void testGetCommentaryById() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
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

        Commentary commentary = new Commentary();
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        when(this.commentaryService.getCommentary((Long) any())).thenReturn(commentary);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/comment/find/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"content\":\"Not all who wander are lost\",\"rate\":1,\"train\":{\"id\":123,\"name\":\"Name\",\"content\":\"Not"
                                        + " all who wander are lost\",\"rate\":1,\"subject\":{\"id\":123,\"name\":\"Name\",\"year\":{\"id\":123,\"name\":\"Name\","
                                        + "\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":null,\"name\":null}}}},\"user\":{\"id\":123,\"indeks\":1"
                                        + ",\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The characteristics of someone"
                                        + " or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked\":true,\"enabled\":true}},"
                                        + "\"user\":{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}}"));
    }

    /**
     * Method under test: {@link CommentaryController#getCommentaryById(Long)}
     */
    @Test
    void testGetCommentaryById2() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
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

        Commentary commentary = new Commentary();
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        when(this.commentaryService.getCommentary((Long) any())).thenReturn(commentary);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/comment/find/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"content\":\"Not all who wander are lost\",\"rate\":1,\"train\":{\"id\":123,\"name\":\"Name\",\"content\":\"Not"
                                        + " all who wander are lost\",\"rate\":1,\"subject\":{\"id\":123,\"name\":\"Name\",\"year\":{\"id\":123,\"name\":\"Name\","
                                        + "\"faculty\":{\"id\":123,\"name\":\"Name\",\"institute\":{\"id\":null,\"name\":null}}}},\"user\":{\"id\":123,\"indeks\":1"
                                        + ",\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The characteristics of someone"
                                        + " or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked\":true,\"enabled\":true}},"
                                        + "\"user\":{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}}"));
    }

    /**
     * Method under test: {@link CommentaryController#getCommentaryByTrain(String)}
     */
    @Test
    void testGetCommentaryByTrain() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/comment/findByTrain")
                .param("name", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link CommentaryController#getCommentaryByUser(String)}
     */
    @Test
    void testGetCommentaryByUser() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/comment/findByUser")
                .param("email", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link CommentaryController#getComments()}
     */
    @Test
    void testGetComments() throws Exception {
        when(this.commentaryService.getCommentary()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/comments");
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CommentaryController#getComments()}
     */
    @Test
    void testGetComments2() throws Exception {
        when(this.commentaryService.getCommentary()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/comments");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CommentaryController#incrementCommentaryByName(Long)}
     */
    @Test
    void testIncrementCommentaryByName() throws Exception {
        doNothing().when(this.commentaryService).incrementRate((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/commentary/increment/{name}", 1L);
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CommentaryController#incrementCommentaryByName(Long)}
     */
    @Test
    void testIncrementCommentaryByName2() throws Exception {
        doNothing().when(this.commentaryService).incrementRate((Long) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/commentary/increment/{name}", 1L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.commentaryController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

