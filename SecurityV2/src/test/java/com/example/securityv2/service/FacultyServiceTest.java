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
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.FacultyRepository;
import com.example.securityv2.repository.InstituteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FacultyService.class})
@ExtendWith(SpringExtension.class)
class FacultyServiceTest {
    @MockBean
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyService facultyService;

    @MockBean
    private InstituteRepository instituteRepository;

    /**
     * Method under test: {@link FacultyService#getFaculty()}
     */
    @Test
    void testGetFaculty() {
        ArrayList<Faculty> facultyList = new ArrayList<>();
        when(this.facultyRepository.findAll()).thenReturn(facultyList);
        List<Faculty> actualFaculty = this.facultyService.getFaculty();
        assertSame(facultyList, actualFaculty);
        assertTrue(actualFaculty.isEmpty());
        verify(this.facultyRepository).findAll();
    }

    /**
     * Method under test: {@link FacultyService#getFaculty()}
     */
    @Test
    void testGetFaculty2() {
        when(this.facultyRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.facultyService.getFaculty());
        verify(this.facultyRepository).findAll();
    }

    /**
     * Method under test: {@link FacultyService#getFaculty(String)}
     */
    @Test
    void testGetFaculty3() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        Optional<Faculty> ofResult = Optional.of(faculty);
        when(this.facultyRepository.findByName((String) any())).thenReturn(ofResult);
        assertSame(faculty, this.facultyService.getFaculty("Name"));
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link FacultyService#getFaculty(String)}
     */
    @Test
    void testGetFaculty4() {
        when(this.facultyRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.facultyService.getFaculty("Name"));
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link FacultyService#getFaculty(String)}
     */
    @Test
    void testGetFaculty5() {
        when(this.facultyRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.facultyService.getFaculty("Name"));
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link FacultyService#getFacultyByInstitute(String)}
     */
    @Test
    void testGetFacultyByInstitute() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        Optional<Institute> ofResult = Optional.of(institute);
        when(this.instituteRepository.findByName((String) any())).thenReturn(ofResult);
        ArrayList<Faculty> facultyList = new ArrayList<>();
        when(this.facultyRepository.findByInstitute((Institute) any())).thenReturn(facultyList);
        List<Faculty> actualFacultyByInstitute = this.facultyService.getFacultyByInstitute("Name");
        assertSame(facultyList, actualFacultyByInstitute);
        assertTrue(actualFacultyByInstitute.isEmpty());
        verify(this.instituteRepository).findByName((String) any());
        verify(this.facultyRepository).findByInstitute((Institute) any());
    }

    /**
     * Method under test: {@link FacultyService#getFacultyByInstitute(String)}
     */
    @Test
    void testGetFacultyByInstitute2() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        Optional<Institute> ofResult = Optional.of(institute);
        when(this.instituteRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.facultyRepository.findByInstitute((Institute) any()))
                .thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.facultyService.getFacultyByInstitute("Name"));
        verify(this.instituteRepository).findByName((String) any());
        verify(this.facultyRepository).findByInstitute((Institute) any());
    }

    /**
     * Method under test: {@link FacultyService#getFacultyByInstitute(String)}
     */
    @Test
    void testGetFacultyByInstitute3() {
        when(this.instituteRepository.findByName((String) any())).thenReturn(Optional.empty());
        when(this.facultyRepository.findByInstitute((Institute) any())).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> this.facultyService.getFacultyByInstitute("Name"));
        verify(this.instituteRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link FacultyService#saveFaculty(Faculty)}
     */
    @Test
    void testSaveFaculty() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        when(this.facultyRepository.save((Faculty) any())).thenReturn(faculty);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");

        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(institute1);
        faculty1.setName("Name");
        assertSame(faculty, this.facultyService.saveFaculty(faculty1));
        verify(this.facultyRepository).save((Faculty) any());
    }

    /**
     * Method under test: {@link FacultyService#saveFaculty(Faculty)}
     */
    @Test
    void testSaveFaculty2() {
        when(this.facultyRepository.save((Faculty) any())).thenThrow(new NotFoundException("An error occurred"));

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        assertThrows(NotFoundException.class, () -> this.facultyService.saveFaculty(faculty));
        verify(this.facultyRepository).save((Faculty) any());
    }

    /**
     * Method under test: {@link FacultyService#updateFaculty(Faculty)}
     */
    @Test
    void testUpdateFaculty() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        when(this.facultyRepository.save((Faculty) any())).thenReturn(faculty);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");

        Faculty faculty1 = new Faculty();
        faculty1.setId(123L);
        faculty1.setInstitute(institute1);
        faculty1.setName("Name");
        assertSame(faculty, this.facultyService.updateFaculty(faculty1));
        verify(this.facultyRepository).save((Faculty) any());
    }

    /**
     * Method under test: {@link FacultyService#updateFaculty(Faculty)}
     */
    @Test
    void testUpdateFaculty2() {
        when(this.facultyRepository.save((Faculty) any())).thenThrow(new NotFoundException("An error occurred"));

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        assertThrows(NotFoundException.class, () -> this.facultyService.updateFaculty(faculty));
        verify(this.facultyRepository).save((Faculty) any());
    }

    /**
     * Method under test: {@link FacultyService#deleteFaculty(Long)}
     */
    @Test
    void testDeleteFaculty() {
        doNothing().when(this.facultyRepository).deleteById((Long) any());
        this.facultyService.deleteFaculty(123L);
        verify(this.facultyRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link FacultyService#deleteFaculty(Long)}
     */
    @Test
    void testDeleteFaculty2() {
        doThrow(new NotFoundException("An error occurred")).when(this.facultyRepository).deleteById((Long) any());
        assertThrows(NotFoundException.class, () -> this.facultyService.deleteFaculty(123L));
        verify(this.facultyRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link FacultyService#setInstituteToFaculty(String, String)}
     */
    @Test
    void testSetInstituteToFaculty() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        Optional<Institute> ofResult = Optional.of(institute);
        when(this.instituteRepository.findByName((String) any())).thenReturn(ofResult);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute1);
        faculty.setName("Name");
        Optional<Faculty> ofResult1 = Optional.of(faculty);
        when(this.facultyRepository.findByName((String) any())).thenReturn(ofResult1);
        this.facultyService.setInstituteToFaculty("Faculty Name", "Institute Name");
        verify(this.instituteRepository).findByName((String) any());
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link FacultyService#setInstituteToFaculty(String, String)}
     */
    @Test
    void testSetInstituteToFaculty2() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        Optional<Institute> ofResult = Optional.of(institute);
        when(this.instituteRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.facultyRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class,
                () -> this.facultyService.setInstituteToFaculty("Faculty Name", "Institute Name"));
        verify(this.instituteRepository).findByName((String) any());
        verify(this.facultyRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link FacultyService#setInstituteToFaculty(String, String)}
     */
    @Test
    void testSetInstituteToFaculty3() {
        when(this.instituteRepository.findByName((String) any())).thenReturn(Optional.empty());

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        Optional<Faculty> ofResult = Optional.of(faculty);
        when(this.facultyRepository.findByName((String) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class,
                () -> this.facultyService.setInstituteToFaculty("Faculty Name", "Institute Name"));
        verify(this.instituteRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link FacultyService#setInstituteToFaculty(String, String)}
     */
    @Test
    void testSetInstituteToFaculty4() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        Optional<Institute> ofResult = Optional.of(institute);
        when(this.instituteRepository.findByName((String) any())).thenReturn(ofResult);
        when(this.facultyRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,
                () -> this.facultyService.setInstituteToFaculty("Faculty Name", "Institute Name"));
        verify(this.instituteRepository).findByName((String) any());
        verify(this.facultyRepository).findByName((String) any());
    }
}

