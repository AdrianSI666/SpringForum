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
import com.example.securityv2.domain.Year;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.FacultyRepository;
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

@ContextConfiguration(classes = {YearService.class})
@ExtendWith(SpringExtension.class)
class YearServiceTest {
    @MockBean
    private FacultyRepository facultyRepository;

    @MockBean
    private YearRepository yearRepository;

    @Autowired
    private YearService yearService;

    /**
     * Method under test: {@link YearService#getYear()}
     */
    @Test
    void testGetYear() {
        ArrayList<Year> yearList = new ArrayList<>();
        when(this.yearRepository.findAll()).thenReturn(yearList);
        List<Year> actualYear = this.yearService.getYear();
        assertSame(yearList, actualYear);
        assertTrue(actualYear.isEmpty());
        verify(this.yearRepository).findAll();
    }

    /**
     * Method under test: {@link YearService#getYear()}
     */
    @Test
    void testGetYear2() {
        when(this.yearRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.yearService.getYear());
        verify(this.yearRepository).findAll();
    }

    /**
     * Method under test: {@link YearService#getYear(String)}
     */
    @Test
    void testGetYear3() {
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
        assertSame(year, this.yearService.getYear("Name"));
        verify(this.yearRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#getYear(String)}
     */
    @Test
    void testGetYear4() {
        when(this.yearRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.yearService.getYear("Name"));
        verify(this.yearRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#getYear(String)}
     */
    @Test
    void testGetYear5() {
        when(this.yearRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.yearService.getYear("Name"));
        verify(this.yearRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#getYearsByFaculty(String)}
     */
    @Test
    void testGetYearsByFaculty() {
        ArrayList<Year> yearList = new ArrayList<>();
        when(this.yearRepository.findByFaculty((Faculty) any())).thenReturn(yearList);

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        Optional<Faculty> ofResult = Optional.of(faculty);
        when(this.facultyRepository.findByName((String) any())).thenReturn(ofResult);
        List<Year> actualYearsByFaculty = this.yearService.getYearsByFaculty("Name");
        assertSame(yearList, actualYearsByFaculty);
        assertTrue(actualYearsByFaculty.isEmpty());
        verify(this.yearRepository).findByFaculty((Faculty) any());
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#getYearsByFaculty(String)}
     */
    @Test
    void testGetYearsByFaculty2() {
        when(this.yearRepository.findByFaculty((Faculty) any())).thenThrow(new NotFoundException("An error occurred"));

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        Optional<Faculty> ofResult = Optional.of(faculty);
        when(this.facultyRepository.findByName((String) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.yearService.getYearsByFaculty("Name"));
        verify(this.yearRepository).findByFaculty((Faculty) any());
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#getYearsByFaculty(String)}
     */
    @Test
    void testGetYearsByFaculty3() {
        when(this.yearRepository.findByFaculty((Faculty) any())).thenReturn(new ArrayList<>());
        when(this.facultyRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.yearService.getYearsByFaculty("Name"));
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#saveYear(Year)}
     */
    @Test
    void testSaveYear() {
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
        when(this.yearRepository.save((Year) any())).thenReturn(year);

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
        assertSame(year, this.yearService.saveYear(year1));
        verify(this.yearRepository).save((Year) any());
    }

    /**
     * Method under test: {@link YearService#saveYear(Year)}
     */
    @Test
    void testSaveYear2() {
        when(this.yearRepository.save((Year) any())).thenThrow(new NotFoundException("An error occurred"));

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
        assertThrows(NotFoundException.class, () -> this.yearService.saveYear(year));
        verify(this.yearRepository).save((Year) any());
    }

    /**
     * Method under test: {@link YearService#updateYear(Year)}
     */
    @Test
    void testUpdateYear() {
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
        when(this.yearRepository.save((Year) any())).thenReturn(year);

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
        assertSame(year, this.yearService.updateYear(year1));
        verify(this.yearRepository).save((Year) any());
    }

    /**
     * Method under test: {@link YearService#updateYear(Year)}
     */
    @Test
    void testUpdateYear2() {
        when(this.yearRepository.save((Year) any())).thenThrow(new NotFoundException("An error occurred"));

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
        assertThrows(NotFoundException.class, () -> this.yearService.updateYear(year));
        verify(this.yearRepository).save((Year) any());
    }

    /**
     * Method under test: {@link YearService#deleteYear(Long)}
     */
    @Test
    void testDeleteYear() {
        doNothing().when(this.yearRepository).deleteById((Long) any());
        this.yearService.deleteYear(123L);
        verify(this.yearRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link YearService#deleteYear(Long)}
     */
    @Test
    void testDeleteYear2() {
        doThrow(new NotFoundException("An error occurred")).when(this.yearRepository).deleteById((Long) any());
        assertThrows(NotFoundException.class, () -> this.yearService.deleteYear(123L));
        verify(this.yearRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link YearService#setFacultyToYear(String, String)}
     */
    @Test
    void testSetFacultyToYear() {
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
        Optional<Faculty> ofResult1 = Optional.of(faculty1);
        when(this.facultyRepository.findByName((String) any())).thenReturn(ofResult1);
        this.yearService.setFacultyToYear("Year Name", "Faculty Name");
        verify(this.yearRepository).findByName((String) any());
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#setFacultyToYear(String, String)}
     */
    @Test
    void testSetFacultyToYear2() {
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
        when(this.facultyRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.yearService.setFacultyToYear("Year Name", "Faculty Name"));
        verify(this.yearRepository).findByName((String) any());
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#setFacultyToYear(String, String)}
     */
    @Test
    void testSetFacultyToYear3() {
        when(this.yearRepository.findByName((String) any())).thenReturn(Optional.empty());

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        Optional<Faculty> ofResult = Optional.of(faculty);
        when(this.facultyRepository.findByName((String) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.yearService.setFacultyToYear("Year Name", "Faculty Name"));
        verify(this.yearRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link YearService#setFacultyToYear(String, String)}
     */
    @Test
    void testSetFacultyToYear4() {
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
        when(this.facultyRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.yearService.setFacultyToYear("Year Name", "Faculty Name"));
        verify(this.yearRepository).findByName((String) any());
        verify(this.facultyRepository).findByName((String) any());
    }
}

