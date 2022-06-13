package com.example.securityv2.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class BadRequestHandlerTest {
    /**
     * Method under test: {@link BadRequestHandler#handleApiRequestException(BadRequestException)}
     */
    @Test
    void testHandleApiRequestException() {
        BadRequestHandler badRequestHandler = new BadRequestHandler();
        ResponseEntity<Object> actualHandleApiRequestExceptionResult = badRequestHandler
                .handleApiRequestException(new BadRequestException("An error occurred"));
        assertTrue(actualHandleApiRequestExceptionResult.hasBody());
        assertTrue(actualHandleApiRequestExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleApiRequestExceptionResult.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST,
                ((ApiException) actualHandleApiRequestExceptionResult.getBody()).getHttpStatus());
        assertEquals("An error occurred", ((ApiException) actualHandleApiRequestExceptionResult.getBody()).getMessage());
    }

    /**
     * Method under test: {@link BadRequestHandler#handleApiRequestException(BadRequestException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleApiRequestException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.securityv2.exception.BadRequestException.getMessage()" because "e" is null
        //       at com.example.securityv2.exception.BadRequestHandler.handleApiRequestException(BadRequestHandler.java:15)
        //   In order to prevent handleApiRequestException(BadRequestException)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handleApiRequestException(BadRequestException).
        //   See https://diff.blue/R013 to resolve this issue.

        (new BadRequestHandler()).handleApiRequestException(null);
    }
}

