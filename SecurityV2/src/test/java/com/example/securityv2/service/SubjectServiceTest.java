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
import com.example.securityv2.domain.Year;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.SubjectRepository;
import com.example.securityv2.repository.YearRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SubjectService.class})
@ExtendWith(SpringExtension.class)
class SubjectServiceTest {
    @MockBean
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectService subjectService;

    @MockBean
    private YearRepository yearRepository;

    /**
     * Method under test: {@link SubjectService#getSubject()}
     */
    @Test
    void testGetSubject() {
        ArrayList<Subject> subjectList = new ArrayList<>();
        when(this.subjectRepository.findAll()).thenReturn(subjectList);
        List<Subject> actualSubject = this.subjectService.getSubject();
        assertSame(subjectList, actualSubject);
        assertTrue(actualSubject.isEmpty());
        verify(this.subjectRepository).findAll();
    }

    /**
     * Method under test: {@link SubjectService#getSubject()}
     */
    @Test
    void testGetSubject2() {
        when(this.subjectRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.subjectService.getSubject());
        verify(this.subjectRepository).findAll();
    }

    /**
     * Method under test: {@link SubjectService#getSubject(String)}
     */
    @Test
    void testGetSubject3() {
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
        assertSame(subject, this.subjectService.getSubject("Name"));
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SubjectService#getSubject(String)}
     */
    @Test
    void testGetSubject4() {
        when(this.subjectRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.subjectService.getSubject("Name"));
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SubjectService#getSubject(String)}
     */
    @Test
    void testGetSubject5() {
        when(this.subjectRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.subjectService.getSubject("Name"));
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SubjectService#getSubjectByYear(String)}
     */
    @Test
    void testGetSubjectByYear() {
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
        Optional<Year> ofResult = Optional.of(year);
        when(this.yearRepository.findByName((String) any())).thenReturn(ofResult);
        ArrayList<Subject> subjectList = new ArrayList<>();
        when(this.subjectRepository.findByYear((Year) any())).thenReturn(subjectList);
        List<Subject> actualSubjectByYear = this.subjectService.getSubjectByYear("Name");
        assertSame(subjectList, actualSubjectByYear);
        assertTrue(actualSubjectByYear.isEmpty());
        verify(this.yearRepository).findByName((String) any());
        verify(this.subjectRepository).findByYear((Year) any());
    }

    /**
     * Method under test: {@link SubjectService#getSubjectByYear(String)}
     */
    @Test
    void testGetSubjectByYear2() {
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
        Optional<Year> ofResult = Optional.of(year);
        when(this.yearRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.subjectRepository.findByYear((Year) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.subjectService.getSubjectByYear("Name"));
        verify(this.yearRepository).findByName((String) any());
        verify(this.subjectRepository).findByYear((Year) any());
    }

    /**
     * Method under test: {@link SubjectService#getSubjectByYear(String)}
     */
    @Test
    void testGetSubjectByYear3() {
        when(this.yearRepository.findByName((String) any())).thenReturn(Optional.empty());
        when(this.subjectRepository.findByYear((Year) any())).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> this.subjectService.getSubjectByYear("Name"));
        verify(this.yearRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SubjectService#saveSubject(Subject)}
     */
    @Test
    void testSaveSubject() {
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
        when(this.subjectRepository.save((Subject) any())).thenReturn(subject);

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
        assertSame(subject, this.subjectService.saveSubject(subject1));
        verify(this.subjectRepository).save((Subject) any());
    }

    /**
     * Method under test: {@link SubjectService#saveSubject(Subject)}
     */
    @Test
    void testSaveSubject2() {
        when(this.subjectRepository.save((Subject) any())).thenThrow(new NotFoundException("An error occurred"));

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
        assertThrows(NotFoundException.class, () -> this.subjectService.saveSubject(subject));
        verify(this.subjectRepository).save((Subject) any());
    }

    /**
     * Method under test: {@link SubjectService#updateSubject(Subject)}
     */
    @Test
    void testUpdateSubject() {
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
        when(this.subjectRepository.save((Subject) any())).thenReturn(subject);

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
        assertSame(subject, this.subjectService.updateSubject(subject1));
        verify(this.subjectRepository).save((Subject) any());
    }

    /**
     * Method under test: {@link SubjectService#updateSubject(Subject)}
     */
    @Test
    void testUpdateSubject2() {
        when(this.subjectRepository.save((Subject) any())).thenThrow(new NotFoundException("An error occurred"));

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
        assertThrows(NotFoundException.class, () -> this.subjectService.updateSubject(subject));
        verify(this.subjectRepository).save((Subject) any());
    }

    /**
     * Method under test: {@link SubjectService#deleteSubject(Long)}
     */
    @Test
    void testDeleteSubject() {
        doNothing().when(this.subjectRepository).deleteById((Long) any());
        this.subjectService.deleteSubject(123L);
        verify(this.subjectRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link SubjectService#deleteSubject(Long)}
     */
    @Test
    void testDeleteSubject2() {
        doThrow(new NotFoundException("An error occurred")).when(this.subjectRepository).deleteById((Long) any());
        assertThrows(NotFoundException.class, () -> this.subjectService.deleteSubject(123L));
        verify(this.subjectRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link SubjectService#setYearToSubject(String, String)}
     */
    @Test
    void testSetYearToSubject() {
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
        Optional<Year> ofResult = Optional.of(year);
        when(this.yearRepository.findByName((String) any())).thenReturn(ofResult);

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

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        subject.setYear(year1);
        Optional<Subject> ofResult1 = Optional.of(subject);
        when(this.subjectRepository.findByName((String) any())).thenReturn(ofResult1);
        this.subjectService.setYearToSubject("Hello from the Dreaming Spires", "Year Name");
        verify(this.yearRepository).findByName((String) any());
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SubjectService#setYearToSubject(String, String)}
     */
    @Test
    void testSetYearToSubject2() {
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
        Optional<Year> ofResult = Optional.of(year);
        when(this.yearRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.subjectRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class,
                () -> this.subjectService.setYearToSubject("Hello from the Dreaming Spires", "Year Name"));
        verify(this.yearRepository).findByName((String) any());
        verify(this.subjectRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SubjectService#setYearToSubject(String, String)}
     */
    @Test
    void testSetYearToSubject3() {
        when(this.yearRepository.findByName((String) any())).thenReturn(Optional.empty());

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
                () -> this.subjectService.setYearToSubject("Hello from the Dreaming Spires", "Year Name"));
        verify(this.yearRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SubjectService#setYearToSubject(String, String)}
     */
    @Test
    void testSetYearToSubject4() {
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
        Optional<Year> ofResult = Optional.of(year);
        when(this.yearRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.subjectRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,
                () -> this.subjectService.setYearToSubject("Hello from the Dreaming Spires", "Year Name"));
        verify(this.yearRepository).findByName((String) any());
        verify(this.subjectRepository).findByName((String) any());
    }
}

