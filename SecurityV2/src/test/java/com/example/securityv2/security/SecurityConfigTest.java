package com.example.securityv2.security;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Role;
import com.example.securityv2.domain.User;
import com.example.securityv2.registration.token.ConfirmationTokenRepository;
import com.example.securityv2.registration.token.ConfirmationTokenService;
import com.example.securityv2.repository.RoleRepository;
import com.example.securityv2.repository.UserRepository;
import com.example.securityv2.service.UserService;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {SecurityConfig.class, BCryptPasswordEncoder.class, AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class SecurityConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @Autowired
    private SecurityConfig securityConfig;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link SecurityConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    void testConfigure() {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(
                this.objectPostProcessor);
        this.securityConfig.configure(authenticationManagerBuilder);
        assertTrue(authenticationManagerBuilder.isConfigured());
    }

    /**
     * Method under test: {@link SecurityConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder.authenticationProvider(org.springframework.security.authentication.AuthenticationProvider)" because "auth" is null
        //       at com.example.securityv2.security.SecurityConfig.configure(SecurityConfig.java:37)
        //   In order to prevent configure(AuthenticationManagerBuilder)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   configure(AuthenticationManagerBuilder).
        //   See https://diff.blue/R013 to resolve this issue.

        this.securityConfig.configure((AuthenticationManagerBuilder) null);
    }

    /**
     * Method under test: {@link SecurityConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure3() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.context.ApplicationContext.getBeanNamesForType(java.lang.Class)" because "context" is null
        //       at org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.<init>(ExpressionUrlAuthorizationConfigurer.java:109)
        //       at org.springframework.security.config.annotation.web.builders.HttpSecurity.authorizeRequests(HttpSecurity.java:1183)
        //       at com.example.securityv2.security.SecurityConfig.configure(SecurityConfig.java:47)
        //   In order to prevent configure(HttpSecurity)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   configure(HttpSecurity).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(this.objectPostProcessor);
        this.securityConfig.configure(new HttpSecurity(this.objectPostProcessor, authenticationBuilder, new HashMap<>()));
    }

    /**
     * Method under test: {@link SecurityConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure4() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.HttpSecurity.cors()" because "http" is null
        //       at com.example.securityv2.security.SecurityConfig.configure(SecurityConfig.java:44)
        //   In order to prevent configure(HttpSecurity)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   configure(HttpSecurity).
        //   See https://diff.blue/R013 to resolve this issue.

        this.securityConfig.configure((HttpSecurity) null);
    }

    /**
     * Method under test: {@link SecurityConfig#corsFilter()}
     */
    @Test
    void testCorsFilter() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by corsFilter()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by corsFilter()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        RoleRepository roleRepository = mock(RoleRepository.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserService userService = new UserService(userRepository, roleRepository, passwordEncoder,
                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class)));

        (new SecurityConfig(userService, new BCryptPasswordEncoder())).corsFilter();
    }

    /**
     * Method under test: {@link SecurityConfig#corsFilter()}
     */
    @Test
    void testCorsFilter2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by corsFilter()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

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
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.of(user));

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        RoleRepository roleRepository = mock(RoleRepository.class);
        when(roleRepository.findByName((String) any())).thenReturn(role);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserService userService = new UserService(userRepository, roleRepository, passwordEncoder,
                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class)));
        userService.addRoleToUser("jane.doe@example.org", "http://localhost:3000");
        (new SecurityConfig(userService, new BCryptPasswordEncoder())).corsFilter();
        verify(userRepository).findByEmail((String) any());
        verify(roleRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SecurityConfig#authenticationManagerBean()}
     */
    @Test
    void testAuthenticationManagerBean() throws Exception {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by authenticationManagerBean()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.securityConfig.authenticationManagerBean();
    }

    /**
     * Method under test: {@link SecurityConfig#daoAuthenticationProvider()}
     */
    @Test
    void testDaoAuthenticationProvider() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by daoAuthenticationProvider()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        RoleRepository roleRepository = mock(RoleRepository.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserService userService = new UserService(userRepository, roleRepository, passwordEncoder,
                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class)));

        DaoAuthenticationProvider actualDaoAuthenticationProviderResult = (new SecurityConfig(userService,
                new BCryptPasswordEncoder())).daoAuthenticationProvider();
        assertTrue(actualDaoAuthenticationProviderResult
                .getUserCache() instanceof org.springframework.security.core.userdetails.cache.NullUserCache);
        assertTrue(actualDaoAuthenticationProviderResult.isHideUserNotFoundExceptions());
        assertFalse(actualDaoAuthenticationProviderResult.isForcePrincipalAsString());
    }

    /**
     * Method under test: {@link SecurityConfig#daoAuthenticationProvider()}
     */
    @Test
    void testDaoAuthenticationProvider2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by daoAuthenticationProvider()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

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
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.of(user));

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        RoleRepository roleRepository = mock(RoleRepository.class);
        when(roleRepository.findByName((String) any())).thenReturn(role);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserService userService = new UserService(userRepository, roleRepository, passwordEncoder,
                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class)));
        userService.addRoleToUser("jane.doe@example.org", "Role Name");
        DaoAuthenticationProvider actualDaoAuthenticationProviderResult = (new SecurityConfig(userService,
                new BCryptPasswordEncoder())).daoAuthenticationProvider();
        assertTrue(actualDaoAuthenticationProviderResult
                .getUserCache() instanceof org.springframework.security.core.userdetails.cache.NullUserCache);
        assertTrue(actualDaoAuthenticationProviderResult.isHideUserNotFoundExceptions());
        assertFalse(actualDaoAuthenticationProviderResult.isForcePrincipalAsString());
        verify(userRepository).findByEmail((String) any());
        verify(roleRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link SecurityConfig#daoAuthenticationProvider()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDaoAuthenticationProvider3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by daoAuthenticationProvider()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: passwordEncoder cannot be null
        //       at org.springframework.util.Assert.notNull(Assert.java:201)
        //       at org.springframework.security.authentication.dao.DaoAuthenticationProvider.setPasswordEncoder(DaoAuthenticationProvider.java:146)
        //       at com.example.securityv2.security.SecurityConfig.daoAuthenticationProvider(SecurityConfig.java:88)
        //   In order to prevent daoAuthenticationProvider()
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   daoAuthenticationProvider().
        //   See https://diff.blue/R013 to resolve this issue.

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
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.of(user));

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        RoleRepository roleRepository = mock(RoleRepository.class);
        when(roleRepository.findByName((String) any())).thenReturn(role);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserService userService = new UserService(userRepository, roleRepository, passwordEncoder,
                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class)));
        userService.addRoleToUser("jane.doe@example.org", "Role Name");
        (new SecurityConfig(userService, null)).daoAuthenticationProvider();
    }
}

