package com.example.securityv2.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class NotFoundHandlerTest {
    /**
     * Method under test: {@link NotFoundHandler#handleApiRequestException(NotFoundException)}
     */
    @Test
    void testHandleApiRequestException() {
        NotFoundHandler notFoundHandler = new NotFoundHandler();
        ResponseEntity<Object> actualHandleApiRequestExceptionResult = notFoundHandler
                .handleApiRequestException(new NotFoundException("An error occurred"));
        assertTrue(actualHandleApiRequestExceptionResult.hasBody());
        assertTrue(actualHandleApiRequestExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.NOT_FOUND, actualHandleApiRequestExceptionResult.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND,
                ((ApiException) actualHandleApiRequestExceptionResult.getBody()).getHttpStatus());
        assertEquals("An error occurred", ((ApiException) actualHandleApiRequestExceptionResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link NotFoundHandler#handleApiRequestException(NotFoundException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleApiRequestException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.securityv2.exception.NotFoundException.getMessage()" because "e" is null
        //       at com.example.securityv2.exception.NotFoundHandler.handleApiRequestException(NotFoundHandler.java:18)
        //   In order to prevent handleApiRequestException(NotFoundException)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handleApiRequestException(NotFoundException).
        //   See https://diff.blue/R013 to resolve this issue.

        (new NotFoundHandler()).handleApiRequestException(null);
    }
}

