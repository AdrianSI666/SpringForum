package com.example.securityv2.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Institute;
import com.example.securityv2.exception.NotFoundException;
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

@ContextConfiguration(classes = {InstituteService.class})
@ExtendWith(SpringExtension.class)
class InstituteServiceTest {
    @MockBean
    private InstituteRepository instituteRepository;

    @Autowired
    private InstituteService instituteService;

    /**
     * Method under test: {@link InstituteService#getInstitute()}
     */
    @Test
    void testGetInstitute() {
        ArrayList<Institute> instituteList = new ArrayList<>();
        when(this.instituteRepository.findAll()).thenReturn(instituteList);
        List<Institute> actualInstitute = this.instituteService.getInstitute();
        assertSame(instituteList, actualInstitute);
        assertTrue(actualInstitute.isEmpty());
        verify(this.instituteRepository).findAll();
    }

    /**
     * Method under test: {@link InstituteService#getInstitute()}
     */
    @Test
    void testGetInstitute2() {
        when(this.instituteRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.instituteService.getInstitute());
        verify(this.instituteRepository).findAll();
    }

    /**
     * Method under test: {@link InstituteService#getInstitute(String)}
     */
    @Test
    void testGetInstitute3() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        Optional<Institute> ofResult = Optional.of(institute);
        when(this.instituteRepository.findByName((String) any())).thenReturn(ofResult);
        assertSame(institute, this.instituteService.getInstitute("Name"));
        verify(this.instituteRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link InstituteService#getInstitute(String)}
     */
    @Test
    void testGetInstitute4() {
        when(this.instituteRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.instituteService.getInstitute("Name"));
        verify(this.instituteRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link InstituteService#getInstitute(String)}
     */
    @Test
    void testGetInstitute5() {
        when(this.instituteRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.instituteService.getInstitute("Name"));
        verify(this.instituteRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link InstituteService#saveInstitute(Institute)}
     */
    @Test
    void testSaveInstitute() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        when(this.instituteRepository.save((Institute) any())).thenReturn(institute);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");
        assertSame(institute, this.instituteService.saveInstitute(institute1));
        verify(this.instituteRepository).save((Institute) any());
    }

    /**
     * Method under test: {@link InstituteService#saveInstitute(Institute)}
     */
    @Test
    void testSaveInstitute2() {
        when(this.instituteRepository.save((Institute) any())).thenThrow(new NotFoundException("An error occurred"));

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        assertThrows(NotFoundException.class, () -> this.instituteService.saveInstitute(institute));
        verify(this.instituteRepository).save((Institute) any());
    }

    /**
     * Method under test: {@link InstituteService#updateInstitute(Institute)}
     */
    @Test
    void testUpdateInstitute() {
        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        when(this.instituteRepository.save((Institute) any())).thenReturn(institute);

        Institute institute1 = new Institute();
        institute1.setId(123L);
        institute1.setName("Name");
        assertSame(institute, this.instituteService.updateInstitute(institute1));
        verify(this.instituteRepository).save((Institute) any());
    }

    /**
     * Method under test: {@link InstituteService#updateInstitute(Institute)}
     */
    @Test
    void testUpdateInstitute2() {
        when(this.instituteRepository.save((Institute) any())).thenThrow(new NotFoundException("An error occurred"));

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");
        assertThrows(NotFoundException.class, () -> this.instituteService.updateInstitute(institute));
        verify(this.instituteRepository).save((Institute) any());
    }

    /**
     * Method under test: {@link InstituteService#deleteInstitute(Long)}
     */
    @Test
    void testDeleteInstitute() {
        doNothing().when(this.instituteRepository).deleteById((Long) any());
        this.instituteService.deleteInstitute(123L);
        verify(this.instituteRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link InstituteService#deleteInstitute(Long)}
     */
    @Test
    void testDeleteInstitute2() {
        doThrow(new NotFoundException("An error occurred")).when(this.instituteRepository).deleteById((Long) any());
        assertThrows(NotFoundException.class, () -> this.instituteService.deleteInstitute(123L));
        verify(this.instituteRepository).deleteById((Long) any());
    }
}

