/*
package com.example.securityv2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Commentary;
import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Train;
import com.example.securityv2.domain.User;
import com.example.securityv2.domain.Year;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.CommentaryRepository;
import com.example.securityv2.repository.TrainRepository;
import com.example.securityv2.repository.UserRepository;

import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CommentaryService.class})
@ExtendWith(SpringExtension.class)
class CommentaryServiceTest {
    @MockBean
    private CommentaryRepository commentaryRepository;

    @Autowired
    private CommentaryService commentaryService;

    @MockBean
    private TrainRepository trainRepository;

    @MockBean
    private UserRepository userRepository;


    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary() {
        when(this.commentaryRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.commentaryService.getCommentary().isEmpty());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary2() {
        when(this.commentaryRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentary());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary(Long)}
     *//*

    @Test
    void testGetCommentary3() {
        Year year = new Year();
        year.setFaculty(new Faculty());
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
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(commentary, this.commentaryService.getCommentary(123L));
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary(Long)}
     *//*

    @Test
    void testGetCommentary4() {
        when(this.commentaryRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentary(123L));
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary5() {
        when(this.commentaryRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.commentaryService.getCommentary().isEmpty());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary6() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting all comments");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting all comments");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Getting all comments");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Getting all comments");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting all comments");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting all comments");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting all comments");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findAll()).thenReturn(commentaryList);
        assertEquals(1, this.commentaryService.getCommentary().size());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary7() {
        when(this.commentaryRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentary());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary8() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting all comments");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting all comments");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Getting all comments");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Getting all comments");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting all comments");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting all comments");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting all comments");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Getting all comments");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Getting all comments");
        subject1.setTrains(new ArrayList<>());
        subject1.setYear(year1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Getting all comments");
        user2.setId(123L);
        user2.setIndeks(8);
        user2.setLocked(true);
        user2.setNickname("Getting all comments");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        user2.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Getting all comments");
        train1.setRate(8);
        train1.setSubject(subject1);
        train1.setUser(user2);

        User user3 = new User();
        user3.setBadges(new ArrayList<>());
        user3.setDescription("The characteristics of someone or something");
        user3.setEmail("jane.doe@example.org");
        user3.setEnabled(true);
        user3.setIcon("Getting all comments");
        user3.setId(123L);
        user3.setIndeks(8);
        user3.setLocked(true);
        user3.setNickname("Getting all comments");
        user3.setPassword("iloveyou");
        user3.setRole(new ArrayList<>());
        user3.setTokens(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(8);
        commentary1.setTrain(train1);
        commentary1.setUser(user3);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary1);
        commentaryList.add(commentary);
        when(this.commentaryRepository.findAll()).thenReturn(commentaryList);
        assertEquals(2, this.commentaryService.getCommentary().size());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    @Disabled("TODO: Complete this test")
    void testGetCommentary9() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Illegal base64 character -1
        //       at java.util.Base64$Decoder.decode0(Base64.java:847)
        //       at java.util.Base64$Decoder.decode(Base64.java:566)
        //       at com.example.securityv2.service.CommentaryService.lambda$getCommentary$0(CommentaryService.java:43)
        //       at java.util.stream.ReferencePipeline$15$1.accept(ReferencePipeline.java:540)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at com.example.securityv2.service.CommentaryService.getCommentary(CommentaryService.java:45)
        //   In order to prevent getCommentary()
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCommentary().
        //   See https://diff.blue/R013 to resolve this issue.

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting all comments");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting all comments");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Getting all comments");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Getting all comments");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting all comments");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting all comments");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting all comments");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());
        Commentary commentary = mock(Commentary.class);
        when(commentary.getAttachment()).thenReturn(new byte[]{-1, 'A', 'A', 'A', 'A', 'A', 'A', 'A'});
        doNothing().when(commentary).setAttachment((byte[]) any());
        doNothing().when(commentary).setContent((String) any());
        doNothing().when(commentary).setId((Long) any());
        doNothing().when(commentary).setRate(anyInt());
        doNothing().when(commentary).setTrain((Train) any());
        doNothing().when(commentary).setUser((User) any());
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findAll()).thenReturn(commentaryList);
        this.commentaryService.getCommentary();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary10() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting all comments");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting all comments");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Getting all comments");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Getting all comments");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting all comments");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting all comments");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting all comments");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());
        Commentary commentary = mock(Commentary.class);
        when(commentary.getAttachment()).thenReturn(new byte[]{});
        doNothing().when(commentary).setAttachment((byte[]) any());
        doNothing().when(commentary).setContent((String) any());
        doNothing().when(commentary).setId((Long) any());
        doNothing().when(commentary).setRate(anyInt());
        doNothing().when(commentary).setTrain((Train) any());
        doNothing().when(commentary).setUser((User) any());
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findAll()).thenReturn(commentaryList);
        assertEquals(1, this.commentaryService.getCommentary().size());
        verify(this.commentaryRepository).findAll();
        verify(commentary).getAttachment();
        verify(commentary).setAttachment((byte[]) any());
        verify(commentary).setContent((String) any());
        verify(commentary).setId((Long) any());
        verify(commentary).setRate(anyInt());
        verify(commentary).setTrain((Train) any());
        verify(commentary).setUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary11() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting all comments");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting all comments");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Getting all comments");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Getting all comments");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting all comments");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting all comments");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting all comments");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findAll()).thenReturn(commentaryList);
        assertEquals(1, this.commentaryService.getCommentary().size());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary(Long)}
     *//*

    @Test
    @Disabled("TODO: Complete this test")
    void testGetCommentary12() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Illegal base64 character -1
        //       at java.util.Base64$Decoder.decode0(Base64.java:847)
        //       at java.util.Base64$Decoder.decode(Base64.java:566)
        //       at com.example.securityv2.service.CommentaryService.getCommentary(CommentaryService.java:53)
        //   In order to prevent getCommentary(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCommentary(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());
        Commentary commentary = mock(Commentary.class);
        when(commentary.getAttachment()).thenReturn(new byte[]{-1, 'A', 'A', 'A', 'A', 'A', 'A', 'A'});
        doNothing().when(commentary).setAttachment((byte[]) any());
        doNothing().when(commentary).setContent((String) any());
        doNothing().when(commentary).setId((Long) any());
        doNothing().when(commentary).setRate(anyInt());
        doNothing().when(commentary).setTrain((Train) any());
        doNothing().when(commentary).setUser((User) any());
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        this.commentaryService.getCommentary(123L);
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary(Long)}
     *//*

    @Test
    void testGetCommentary13() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());
        Commentary commentary = mock(Commentary.class);
        when(commentary.getAttachment()).thenReturn(new byte[]{});
        doNothing().when(commentary).setAttachment((byte[]) any());
        doNothing().when(commentary).setContent((String) any());
        doNothing().when(commentary).setId((Long) any());
        doNothing().when(commentary).setRate(anyInt());
        doNothing().when(commentary).setTrain((Train) any());
        doNothing().when(commentary).setUser((User) any());
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        this.commentaryService.getCommentary(123L);
        verify(this.commentaryRepository).findById((Long) any());
        verify(commentary).getAttachment();
        verify(commentary).setAttachment((byte[]) any());
        verify(commentary).setContent((String) any());
        verify(commentary).setId((Long) any());
        verify(commentary).setRate(anyInt());
        verify(commentary).setTrain((Train) any());
        verify(commentary).setUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary14() {
        when(this.commentaryRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentary());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    void testGetCommentary15() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting all comments");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting all comments");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Getting all comments");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Getting all comments");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting all comments");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting all comments");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting all comments");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Getting all comments");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Getting all comments");
        subject1.setTrains(new ArrayList<>());
        subject1.setYear(year1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Getting all comments");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Getting all comments");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        user2.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Getting all comments");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user2);

        User user3 = new User();
        user3.setBadges(new ArrayList<>());
        user3.setDescription("The characteristics of someone or something");
        user3.setEmail("jane.doe@example.org");
        user3.setEnabled(true);
        user3.setIcon("Getting all comments");
        user3.setId(123L);
        user3.setIndeks(1);
        user3.setLocked(true);
        user3.setNickname("Getting all comments");
        user3.setPassword("iloveyou");
        user3.setRole(new ArrayList<>());
        user3.setTokens(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(1);
        commentary1.setTrain(train1);
        commentary1.setUser(user3);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary1);
        commentaryList.add(commentary);
        when(this.commentaryRepository.findAll()).thenReturn(commentaryList);
        assertEquals(2, this.commentaryService.getCommentary().size());
        verify(this.commentaryRepository).findAll();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary()}
     *//*

    @Test
    @Disabled("TODO: Complete this test")
    void testGetCommentary16() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Illegal base64 character -1
        //       at java.util.Base64$Decoder.decode0(Base64.java:847)
        //       at java.util.Base64$Decoder.decode(Base64.java:566)
        //       at com.example.securityv2.service.CommentaryService.lambda$getCommentary$0(CommentaryService.java:43)
        //       at java.util.stream.ReferencePipeline$15$1.accept(ReferencePipeline.java:540)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at com.example.securityv2.service.CommentaryService.getCommentary(CommentaryService.java:45)
        //   In order to prevent getCommentary()
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCommentary().
        //   See https://diff.blue/R013 to resolve this issue.

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting all comments");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting all comments");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Getting all comments");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Getting all comments");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting all comments");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting all comments");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting all comments");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());
        Commentary commentary = mock(Commentary.class);
        when(commentary.getAttachment()).thenReturn(new byte[]{-1, 'A', 'A', 'A', 'A', 'A', 'A', 'A'});
        doNothing().when(commentary).setAttachment((byte[]) any());
        doNothing().when(commentary).setContent((String) any());
        doNothing().when(commentary).setId((Long) any());
        doNothing().when(commentary).setRate(anyInt());
        doNothing().when(commentary).setTrain((Train) any());
        doNothing().when(commentary).setUser((User) any());
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findAll()).thenReturn(commentaryList);
        this.commentaryService.getCommentary();
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary(Long)}
     *//*

    @Test
    void testGetCommentary17() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        Commentary actualCommentary = this.commentaryService.getCommentary(123L);
        assertSame(commentary, actualCommentary);
        assertEquals(6, actualCommentary.getAttachment().length);
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentary(Long)}
     *//*

    @Test
    @Disabled("TODO: Complete this test")
    void testGetCommentary18() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Illegal base64 character -1
        //       at java.util.Base64$Decoder.decode0(Base64.java:847)
        //       at java.util.Base64$Decoder.decode(Base64.java:566)
        //       at com.example.securityv2.service.CommentaryService.getCommentary(CommentaryService.java:53)
        //   In order to prevent getCommentary(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCommentary(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());
        Commentary commentary = mock(Commentary.class);
        when(commentary.getAttachment()).thenReturn(new byte[]{-1, 'A', 'A', 'A', 'A', 'A', 'A', 'A'});
        doNothing().when(commentary).setAttachment((byte[]) any());
        doNothing().when(commentary).setContent((String) any());
        doNothing().when(commentary).setId((Long) any());
        doNothing().when(commentary).setRate(anyInt());
        doNothing().when(commentary).setTrain((Train) any());
        doNothing().when(commentary).setUser((User) any());
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        this.commentaryService.getCommentary(123L);
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser() {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(new ArrayList<>());
        assertTrue(this.commentaryService.getCommentaryByUser("jane.doe@example.org").isEmpty());
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }


    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser2() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByUser((User) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser3() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser4() {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(new ArrayList<>());
        assertTrue(this.commentaryService.getCommentaryByUser("jane.doe@example.org").isEmpty());
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser5() {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByUser((User) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser6() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser7() throws UnsupportedEncodingException {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting commentary by user {}");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting commentary by user {}");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting commentary by user {}");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting commentary by user {}");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting commentary by user {}");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Getting commentary by user {}");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Getting commentary by user {}");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        user2.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user2);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(commentaryList);
        assertEquals(1, this.commentaryService.getCommentaryByUser("jane.doe@example.org").size());
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser8() throws UnsupportedEncodingException {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting commentary by user {}");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting commentary by user {}");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting commentary by user {}");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting commentary by user {}");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting commentary by user {}");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Getting commentary by user {}");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Getting commentary by user {}");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        user2.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user2);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Getting commentary by user {}");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Getting commentary by user {}");
        subject1.setTrains(new ArrayList<>());
        subject1.setYear(year1);

        User user3 = new User();
        user3.setBadges(new ArrayList<>());
        user3.setDescription("The characteristics of someone or something");
        user3.setEmail("jane.doe@example.org");
        user3.setEnabled(true);
        user3.setIcon("Getting commentary by user {}");
        user3.setId(123L);
        user3.setIndeks(8);
        user3.setLocked(true);
        user3.setNickname("Getting commentary by user {}");
        user3.setPassword("iloveyou");
        user3.setRole(new ArrayList<>());
        user3.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Getting commentary by user {}");
        train1.setRate(8);
        train1.setSubject(subject1);
        train1.setUser(user3);

        User user4 = new User();
        user4.setBadges(new ArrayList<>());
        user4.setDescription("The characteristics of someone or something");
        user4.setEmail("jane.doe@example.org");
        user4.setEnabled(true);
        user4.setIcon("Getting commentary by user {}");
        user4.setId(123L);
        user4.setIndeks(8);
        user4.setLocked(true);
        user4.setNickname("Getting commentary by user {}");
        user4.setPassword("iloveyou");
        user4.setRole(new ArrayList<>());
        user4.setTokens(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(8);
        commentary1.setTrain(train1);
        commentary1.setUser(user4);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary1);
        commentaryList.add(commentary);
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(commentaryList);
        assertEquals(2, this.commentaryService.getCommentaryByUser("jane.doe@example.org").size());
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser9() {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByUser((User) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser10() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser11() throws UnsupportedEncodingException {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting commentary by user {}");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting commentary by user {}");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting commentary by user {}");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting commentary by user {}");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting commentary by user {}");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Getting commentary by user {}");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Getting commentary by user {}");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        user2.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user2);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(commentaryList);
        assertEquals(1, this.commentaryService.getCommentaryByUser("jane.doe@example.org").size());
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByUser(String)}
     *//*

    @Test
    void testGetCommentaryByUser12() throws UnsupportedEncodingException {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Getting commentary by user {}");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Getting commentary by user {}");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting commentary by user {}");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting commentary by user {}");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Getting commentary by user {}");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Getting commentary by user {}");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Getting commentary by user {}");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        user2.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user2);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Getting commentary by user {}");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Getting commentary by user {}");
        subject1.setTrains(new ArrayList<>());
        subject1.setYear(year1);

        User user3 = new User();
        user3.setBadges(new ArrayList<>());
        user3.setDescription("The characteristics of someone or something");
        user3.setEmail("jane.doe@example.org");
        user3.setEnabled(true);
        user3.setIcon("Getting commentary by user {}");
        user3.setId(123L);
        user3.setIndeks(1);
        user3.setLocked(true);
        user3.setNickname("Getting commentary by user {}");
        user3.setPassword("iloveyou");
        user3.setRole(new ArrayList<>());
        user3.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Getting commentary by user {}");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user3);

        User user4 = new User();
        user4.setBadges(new ArrayList<>());
        user4.setDescription("The characteristics of someone or something");
        user4.setEmail("jane.doe@example.org");
        user4.setEnabled(true);
        user4.setIcon("Getting commentary by user {}");
        user4.setId(123L);
        user4.setIndeks(1);
        user4.setLocked(true);
        user4.setNickname("Getting commentary by user {}");
        user4.setPassword("iloveyou");
        user4.setRole(new ArrayList<>());
        user4.setTokens(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(1);
        commentary1.setTrain(train1);
        commentary1.setUser(user4);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary1);
        commentaryList.add(commentary);
        when(this.commentaryRepository.findByUser((User) any())).thenReturn(commentaryList);
        assertEquals(2, this.commentaryService.getCommentaryByUser("jane.doe@example.org").size());
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findByUser((User) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain() {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByTrain((Train) any())).thenReturn(new ArrayList<>());
        assertTrue(this.commentaryService.getCommentaryByTrain("Name").isEmpty());
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findByTrain((Train) any());
    }


    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain2() {
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
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByTrain((Train) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findByTrain((Train) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain3() {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());
        when(this.commentaryRepository.findByTrain((Train) any())).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain4() {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByTrain((Train) any())).thenReturn(new ArrayList<>());
        assertTrue(this.commentaryService.getCommentaryByTrain("Name").isEmpty());
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findByTrain((Train) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain5() {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByTrain((Train) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findByTrain((Train) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain6() {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());
        when(this.commentaryRepository.findByTrain((Train) any())).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain7() throws UnsupportedEncodingException {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Getting commentary by train {}");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Getting commentary by train {}");
        subject1.setTrains(new ArrayList<>());
        subject1.setYear(year1);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting commentary by train {}");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting commentary by train {}");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Getting commentary by train {}");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Getting commentary by train {}");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Getting commentary by train {}");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        user2.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train1);
        commentary.setUser(user2);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findByTrain((Train) any())).thenReturn(commentaryList);
        assertEquals(1, this.commentaryService.getCommentaryByTrain("Name").size());
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findByTrain((Train) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain8() {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findByTrain((Train) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findByTrain((Train) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain9() {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());
        when(this.commentaryRepository.findByTrain((Train) any())).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> this.commentaryService.getCommentaryByTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#getCommentaryByTrain(String)}
     *//*

    @Test
    void testGetCommentaryByTrain10() throws UnsupportedEncodingException {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Getting commentary by train {}");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Getting commentary by train {}");
        subject1.setTrains(new ArrayList<>());
        subject1.setYear(year1);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Getting commentary by train {}");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Getting commentary by train {}");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        user1.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Getting commentary by train {}");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user1);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Getting commentary by train {}");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Getting commentary by train {}");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        user2.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train1);
        commentary.setUser(user2);

        ArrayList<Commentary> commentaryList = new ArrayList<>();
        commentaryList.add(commentary);
        when(this.commentaryRepository.findByTrain((Train) any())).thenReturn(commentaryList);
        assertEquals(1, this.commentaryService.getCommentaryByTrain("Name").size());
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findByTrain((Train) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#saveCommentary(Commentary)}
     *//*

    @Test
    void testSaveCommentary() {
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
        when(this.commentaryRepository.save((Commentary) any())).thenReturn(commentary);

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
        assertSame(commentary, this.commentaryService.saveCommentary(commentary1));
        verify(this.commentaryRepository).save((Commentary) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#saveCommentary(Commentary)}
     *//*

    @Test
    void testSaveCommentary2() throws UnsupportedEncodingException {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        when(this.commentaryRepository.save((Commentary) any())).thenReturn(commentary);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Name");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setTrains(new ArrayList<>());
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
        user2.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
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
        user3.setTokens(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(1);
        commentary1.setTrain(train1);
        commentary1.setUser(user3);
        assertSame(commentary, this.commentaryService.saveCommentary(commentary1));
        verify(this.commentaryRepository).save((Commentary) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#saveCommentary(Commentary)}
     *//*

    @Test
    void testSaveCommentary3() throws UnsupportedEncodingException {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        when(this.commentaryRepository.save((Commentary) any())).thenReturn(commentary);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Name");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setTrains(new ArrayList<>());
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
        user2.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
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
        user3.setTokens(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(1);
        commentary1.setTrain(train1);
        commentary1.setUser(user3);
        assertSame(commentary, this.commentaryService.saveCommentary(commentary1));
        verify(this.commentaryRepository).save((Commentary) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#updateCommentary(Commentary)}
     *//*

    @Test
    void testUpdateCommentary() {
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
        when(this.commentaryRepository.save((Commentary) any())).thenReturn(commentary);

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
        assertSame(commentary, this.commentaryService.updateCommentary(commentary1));
        verify(this.commentaryRepository).save((Commentary) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#updateCommentary(Commentary)}
     *//*

    @Test
    void testUpdateCommentary2() throws UnsupportedEncodingException {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        when(this.commentaryRepository.save((Commentary) any())).thenReturn(commentary);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Name");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setTrains(new ArrayList<>());
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
        user2.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
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
        user3.setTokens(new ArrayList<>());

        Commentary commentary1 = new Commentary();
        commentary1.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary1.setContent("Not all who wander are lost");
        commentary1.setId(123L);
        commentary1.setRate(1);
        commentary1.setTrain(train1);
        commentary1.setUser(user3);
        assertSame(commentary, this.commentaryService.updateCommentary(commentary1));
        verify(this.commentaryRepository).save((Commentary) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#deleteCommentary(Long)}
     *//*

    @Test
    void testDeleteCommentary() {
        doNothing().when(this.commentaryRepository).deleteById((Long) any());
        this.commentaryService.deleteCommentary(123L);
        verify(this.commentaryRepository).deleteById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#deleteCommentary(Long)}
     *//*

    @Test
    void testDeleteCommentary2() {
        doThrow(new NotFoundException("An error occurred")).when(this.commentaryRepository).deleteById((Long) any());
        assertThrows(NotFoundException.class, () -> this.commentaryService.deleteCommentary(123L));
        verify(this.commentaryRepository).deleteById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#deleteCommentary(Long)}
     *//*

    @Test
    void testDeleteCommentary3() {
        doNothing().when(this.commentaryRepository).deleteById((Long) any());
        this.commentaryService.deleteCommentary(123L);
        verify(this.commentaryRepository).deleteById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#deleteCommentary(Long)}
     *//*

    @Test
    void testDeleteCommentary4() {
        doThrow(new NotFoundException("An error occurred")).when(this.commentaryRepository).deleteById((Long) any());
        assertThrows(NotFoundException.class, () -> this.commentaryService.deleteCommentary(123L));
        verify(this.commentaryRepository).deleteById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setTrianToCommentary(Long, String)}
     *//*

    @Test
    void testSetTrianToCommentary() {
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
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
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

        Commentary commentary = new Commentary();
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train1);
        commentary.setUser(user2);
        Optional<Commentary> ofResult1 = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult1);
        this.commentaryService.setTrianToCommentary(123L, "Train Name");
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setTrianToCommentary(Long, String)}
     *//*

    @Test
    void testSetTrianToCommentary2() {
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
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.setTrianToCommentary(123L, "Train Name"));
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setTrianToCommentary(Long, String)}
     *//*

    @Test
    void testSetTrianToCommentary3() {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());

        Year year = new Year();
        year.setFaculty(new Faculty());
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
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.commentaryService.setTrianToCommentary(123L, "Train Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setTrianToCommentary(Long, String)}
     *//*

    @Test
    void testSetTrianToCommentary4() throws UnsupportedEncodingException {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);

        Year year1 = new Year();
        year1.setFaculty(new Faculty());
        year1.setId(123L);
        year1.setName("Name");
        year1.setSubjects(new ArrayList<>());

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setTrains(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Train train1 = new Train();
        train1.setCommentaries(new ArrayList<>());
        train1.setContent("Not all who wander are lost");
        train1.setId(123L);
        train1.setName("Name");
        train1.setRate(1);
        train1.setSubject(subject1);
        train1.setUser(user1);

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
        user2.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train1);
        commentary.setUser(user2);
        Optional<Commentary> ofResult1 = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult1);
        this.commentaryService.setTrianToCommentary(123L, "Train Name");
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setTrianToCommentary(Long, String)}
     *//*

    @Test
    void testSetTrianToCommentary5() {
        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(new Institute());
        faculty.setName("Name");
        faculty.setYears(new ArrayList<>());

        Year year = new Year();
        year.setFaculty(faculty);
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user);
        Optional<Train> ofResult = Optional.of(train);
        when(this.trainRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.commentaryService.setTrianToCommentary(123L, "Train Name"));
        verify(this.trainRepository).findByName((String) any());
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setTrianToCommentary(Long, String)}
     *//*

    @Test
    void testSetTrianToCommentary6() throws UnsupportedEncodingException {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.commentaryService.setTrianToCommentary(123L, "Train Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setUserToCommentary(Long, String)}
     *//*

    @Test
    void testSetUserToCommentary() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setYear(year);

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

        Train train = new Train();
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user1);

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

        Commentary commentary = new Commentary();
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user2);
        Optional<Commentary> ofResult1 = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult1);
        this.commentaryService.setUserToCommentary(123L, "jane.doe@example.org");
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setUserToCommentary(Long, String)}
     *//*

    @Test
    void testSetUserToCommentary2() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class,
                () -> this.commentaryService.setUserToCommentary(123L, "jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setUserToCommentary(Long, String)}
     *//*

    @Test
    void testSetUserToCommentary3() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());

        Year year = new Year();
        year.setFaculty(new Faculty());
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
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class,
                () -> this.commentaryService.setUserToCommentary(123L, "jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setUserToCommentary(Long, String)}
     *//*

    @Test
    void testSetUserToCommentary4() throws UnsupportedEncodingException {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
        subject.setYear(year);

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
        user1.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
        train.setContent("Not all who wander are lost");
        train.setId(123L);
        train.setName("Name");
        train.setRate(1);
        train.setSubject(subject);
        train.setUser(user1);

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
        user2.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user2);
        Optional<Commentary> ofResult1 = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult1);
        this.commentaryService.setUserToCommentary(123L, "jane.doe@example.org");
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setUserToCommentary(Long, String)}
     *//*

    @Test
    void testSetUserToCommentary5() {
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
        user.setTokens(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.commentaryRepository.findById((Long) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class,
                () -> this.commentaryService.setUserToCommentary(123L, "jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#setUserToCommentary(Long, String)}
     *//*

    @Test
    void testSetUserToCommentary6() throws UnsupportedEncodingException {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());

        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class,
                () -> this.commentaryService.setUserToCommentary(123L, "jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#incrementRate(Long)}
     *//*

    @Test
    void testIncrementRate() {
        Year year = new Year();
        year.setFaculty(new Faculty());
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
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        this.commentaryService.incrementRate(123L);
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#incrementRate(Long)}
     *//*

    @Test
    void testIncrementRate2() {
        when(this.commentaryRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.commentaryService.incrementRate(123L));
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#incrementRate(Long)}
     *//*

    @Test
    void testIncrementRate3() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        this.commentaryService.incrementRate(123L);
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#incrementRate(Long)}
     *//*

    @Test
    void testIncrementRate4() {
        when(this.commentaryRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.commentaryService.incrementRate(123L));
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#decrementRate(Long)}
     *//*

    @Test
    void testDecrementRate() {
        Year year = new Year();
        year.setFaculty(new Faculty());
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
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        this.commentaryService.decrementRate(123L);
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#decrementRate(Long)}
     *//*

    @Test
    void testDecrementRate2() {
        when(this.commentaryRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.commentaryService.decrementRate(123L));
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#decrementRate(Long)}
     *//*

    @Test
    void testDecrementRate3() throws UnsupportedEncodingException {
        Year year = new Year();
        year.setFaculty(new Faculty());
        year.setId(123L);
        year.setName("Name");
        year.setSubjects(new ArrayList<>());

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setTrains(new ArrayList<>());
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
        user.setTokens(new ArrayList<>());

        Train train = new Train();
        train.setCommentaries(new ArrayList<>());
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
        user1.setTokens(new ArrayList<>());

        Commentary commentary = new Commentary();
        commentary.setAttachment("AAAAAAAA".getBytes("UTF-8"));
        commentary.setContent("Not all who wander are lost");
        commentary.setId(123L);
        commentary.setRate(1);
        commentary.setTrain(train);
        commentary.setUser(user1);
        Optional<Commentary> ofResult = Optional.of(commentary);
        when(this.commentaryRepository.findById((Long) any())).thenReturn(ofResult);
        this.commentaryService.decrementRate(123L);
        verify(this.commentaryRepository).findById((Long) any());
    }

    */
/**
     * Method under test: {@link CommentaryService#decrementRate(Long)}
     *//*

    @Test
    void testDecrementRate4() {
        when(this.commentaryRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.commentaryService.decrementRate(123L));
        verify(this.commentaryRepository).findById((Long) any());
    }
}

*/
