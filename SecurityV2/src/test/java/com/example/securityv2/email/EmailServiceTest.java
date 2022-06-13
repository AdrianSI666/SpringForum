package com.example.securityv2.email;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailService.class})
@ExtendWith(SpringExtension.class)
class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @MockBean
    private JavaMailSender javaMailSender;

    /**
     * Method under test: {@link EmailService#send(String, String)}
     */
    @Test
    void testSend() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.emailService.send("alice.liddell@example.org", "jane.doe@example.org");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }

    /**
     * Method under test: {@link EmailService#send(String, String)}
     */
    @Test
    void testSend2() throws MailException {
        doThrow(new IllegalStateException("utf-8")).when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        assertThrows(IllegalStateException.class,
                () -> this.emailService.send("alice.liddell@example.org", "jane.doe@example.org"));
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }

    /**
     * Method under test: {@link EmailService#send(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSend3() throws MailException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.mail.internet.MimePart.setContent(Object, String)" because "mimePart" is null
        //       at org.springframework.mail.javamail.MimeMessageHelper.setHtmlTextToMimePart(MimeMessageHelper.java:882)
        //       at org.springframework.mail.javamail.MimeMessageHelper.setText(MimeMessageHelper.java:820)
        //       at com.example.securityv2.email.EmailService.send(EmailService.java:30)
        //   In order to prevent send(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   send(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(null);
        this.emailService.send("alice.liddell@example.org", "jane.doe@example.org");
    }

    /**
     * Method under test: {@link EmailService#send(String, String)}
     */
    @Test
    void testSend4() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        assertThrows(IllegalStateException.class,
                () -> this.emailService.send("Confirm your email", "jane.doe@example.org"));
        verify(this.javaMailSender).createMimeMessage();
    }
}

