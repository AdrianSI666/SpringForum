/*
package com.example.securityv2.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CommentaryTest {
*/
/*
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Commentary#Commentary(String, Train, User)}
     *   <li>{@link Commentary#setContent(String)}
     *   <li>{@link Commentary#setId(Long)}
     *   <li>{@link Commentary#setRate(int)}
     *   <li>{@link Commentary#setTrain(Train)}
     *   <li>{@link Commentary#setUser(User)}
     *   <li>{@link Commentary#getContent()}
     *   <li>{@link Commentary#getId()}
     *   <li>{@link Commentary#getRate()}
     *   <li>{@link Commentary#getTrain()}
     *   <li>{@link Commentary#getUser()}
     * </ul>*//*



    @Test
    void testConstructor() {
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
        Commentary actualCommentary = new Commentary("Not all who wander are lost", train, user1);
        actualCommentary.setContent("Not all who wander are lost");
        actualCommentary.setId(123L);
        actualCommentary.setRate(1);
        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(new Institute());
        faculty1.setName("Name");
        faculty1.setYears(new ArrayList<>());
        Year year1 = new Year();
        year1.setFaculty(faculty1);
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
        actualCommentary.setTrain(train1);
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
        actualCommentary.setUser(user3);
        assertEquals("Not all who wander are lost", actualCommentary.getContent());
        assertEquals(123L, actualCommentary.getId().longValue());
        assertEquals(1, actualCommentary.getRate());
        assertSame(train1, actualCommentary.getTrain());
        assertSame(user3, actualCommentary.getUser());
    }
}

*/
