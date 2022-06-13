package com.example.securityv2.repository;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class YearRepositoryTest {
    /**
     * Method under test: {@link YearRepository#findByName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByName() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
        //   In order to prevent findByName(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findByName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        YearRepository yearRepository = null;
        yearRepository.findByName("foo");
    }

    /**
     * Method under test: {@link YearRepository#findByFaculty(Faculty)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByFaculty() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   In order to prevent findByFaculty(Faculty)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findByFaculty(Faculty).
        //   See https://diff.blue/R013 to resolve this issue.

        YearRepository yearRepository = null;

        Institute institute = new Institute();
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        yearRepository.findByFaculty(faculty);
    }

    /**
     * Method under test: {@link YearRepository#findByFaculty(Faculty)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByFaculty2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   In order to prevent findByFaculty(Faculty)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findByFaculty(Faculty).
        //   See https://diff.blue/R013 to resolve this issue.

        YearRepository yearRepository = null;
        Institute institute = mock(Institute.class);
        doNothing().when(institute).setId((Long) any());
        doNothing().when(institute).setName((String) any());
        institute.setId(123L);
        institute.setName("Name");

        Faculty faculty = new Faculty();
        faculty.setId(123L);
        faculty.setInstitute(institute);
        faculty.setName("Name");
        yearRepository.findByFaculty(faculty);
    }
}

