package com.example.securityv2.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Train;
import com.example.securityv2.domain.User;
import com.example.securityv2.domain.Year;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.SubjectRepository;
import com.example.securityv2.repository.TrainRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TrainService.class})
@ExtendWith(SpringExtension.class)
class TrainServiceTest {
    @MockBean
    private SubjectRepository subjectRepository;

    @MockBean
    private TrainRepository trainRepository;

    @Autowired
    private TrainService trainService;

    /**
     * Method under test: {@link TrainService#getTrain()}
     */
    @Test
    void testGetTrain() {
        ArrayList<Train> trainList = new ArrayList<>();
        when(this.trainRepository.findAll()).thenReturn(trainList);
        List<Train> actualTrain = this.trainService.getTrain();
        assertSame(trainList, actualTrain);
        assertTrue(actualTrain.isEmpty());
        verify(this.trainRepository).findAll();
    }

    /**
     * Method under test: {@link TrainService#getTrain()}
     */
    @Test
    void testGetTrain2() {
        when(this.trainRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.trainService.getTrain());
        verify(this.trainRepository).findAll();
    }

    /**
     * Method under test: {@link TrainService#getTrain(String)}
     */
    @Test
    void testGetTrain3() {
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
        assertSame(train, this.trainService.getTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#getTrain(String)}
     */
    @Test
    void testGetTrain4() {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.trainService.getTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#getTrain(String)}
     */
    @Test
    void testGetTrain5() {
        when(this.trainRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.trainService.getTrain("Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#getTrainsBySubject(String)}
     */
    @Test
    void testGetTrainsBySubject() {
        ArrayList<Train> trainList = new ArrayList<>();
        when(this.trainRepository.findBySubject((Subject) any())).thenReturn(trainList);

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
        Optional<Subject> ofResult = Optional.of(subject);
        when(this.subjectRepository.findByName((String) any())).thenReturn(ofResult);
        List<Train> actualTrainsBySubject = this.trainService.getTrainsBySubject("Name");
        assertSame(trainList, actualTrainsBySubject);
        assertTrue(actualTrainsBySubject.isEmpty());
        verify(this.trainRepository).findBySubject((Subject) any());
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#getTrainsBySubject(String)}
     */
    @Test
    void testGetTrainsBySubject2() {
        when(this.trainRepository.findBySubject((Subject) any())).thenThrow(new NotFoundException("An error occurred"));

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
        Optional<Subject> ofResult = Optional.of(subject);
        when(this.subjectRepository.findByName((String) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.trainService.getTrainsBySubject("Name"));
        verify(this.trainRepository).findBySubject((Subject) any());
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#getTrainsBySubject(String)}
     */
    @Test
    void testGetTrainsBySubject3() {
        when(this.trainRepository.findBySubject((Subject) any())).thenReturn(new ArrayList<>());
        when(this.subjectRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.trainService.getTrainsBySubject("Name"));
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#saveTrain(Train)}
     */
    @Test
    void testSaveTrain() {
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
        when(this.trainRepository.save((Train) any())).thenReturn(train);

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
        assertSame(train, this.trainService.saveTrain(train1));
        verify(this.trainRepository).save((Train) any());
    }

    /**
     * Method under test: {@link TrainService#updateTrain(Train)}
     */
    @Test
    void testUpdateTrain() {
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
        when(this.trainRepository.save((Train) any())).thenReturn(train);

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
        assertSame(train, this.trainService.updateTrain(train1));
        verify(this.trainRepository).save((Train) any());
    }

    /**
     * Method under test: {@link TrainService#deleteTrain(Long)}
     */
    @Test
    void testDeleteTrain() {
        doNothing().when(this.trainRepository).deleteById((Long) any());
        this.trainService.deleteTrain(123L);
        verify(this.trainRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link TrainService#deleteTrain(Long)}
     */
    @Test
    void testDeleteTrain2() {
        doThrow(new NotFoundException("An error occurred")).when(this.trainRepository).deleteById((Long) any());
        assertThrows(NotFoundException.class, () -> this.trainService.deleteTrain(123L));
        verify(this.trainRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link TrainService#setSubjectToTrain(String, String)}
     */
    @Test
    void testSetSubjectToTrain() {
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

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(institute);
        faculty1.setName("Name");

        Year year1 = new Year();
        year1.setFaculty(faculty1);
        year1.setId(123L);
        year1.setName("Name");

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        subject1.setYear(year1);
        Optional<Subject> ofResult1 = Optional.of(subject1);
        when(this.subjectRepository.findByName((String) any())).thenReturn(ofResult1);
        this.trainService.setSubjectToTrain("Train Name", "Hello from the Dreaming Spires");
        verify(this.trainRepository).findByName((String) any());
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#setSubjectToTrain(String, String)}
     */
    @Test
    void testSetSubjectToTrain2() {
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
        when(this.subjectRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class,
                () -> this.trainService.setSubjectToTrain("Train Name", "Hello from the Dreaming Spires"));
        verify(this.trainRepository).findByName((String) any());
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#setSubjectToTrain(String, String)}
     */
    @Test
    void testSetSubjectToTrain3() {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());

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
        Optional<Subject> ofResult = Optional.of(subject);
        when(this.subjectRepository.findByName((String) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class,
                () -> this.trainService.setSubjectToTrain("Train Name", "Hello from the Dreaming Spires"));
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#setSubjectToTrain(String, String)}
     */
    @Test
    void testSetSubjectToTrain4() {
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
        when(this.subjectRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,
                () -> this.trainService.setSubjectToTrain("Train Name", "Hello from the Dreaming Spires"));
        verify(this.trainRepository).findByName((String) any());
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#incrementRate(String)}
     */
    @Test
    void testIncrementRate() {
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
        this.trainService.incrementRate("Train Name");
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#incrementRate(String)}
     */
    @Test
    void testIncrementRate2() {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.trainService.incrementRate("Train Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#incrementRate(String)}
     */
    @Test
    void testIncrementRate3() {
        when(this.trainRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.trainService.incrementRate("Train Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#decrementRate(String)}
     */
    @Test
    void testDecrementRate() {
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
        this.trainService.decrementRate("Train Name");
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#decrementRate(String)}
     */
    @Test
    void testDecrementRate2() {
        when(this.trainRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.trainService.decrementRate("Train Name"));
        verify(this.trainRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link TrainService#decrementRate(String)}
     */
    @Test
    void testDecrementRate3() {
        when(this.trainRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.trainService.decrementRate("Train Name"));
        verify(this.trainRepository).findByName((String) any());
    }
}

