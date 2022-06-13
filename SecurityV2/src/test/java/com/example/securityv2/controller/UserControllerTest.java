package com.example.securityv2.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.Role;
import com.example.securityv2.domain.User;
import com.example.securityv2.registration.token.ConfirmationTokenRepository;
import com.example.securityv2.registration.token.ConfirmationTokenService;
import com.example.securityv2.repository.BadgeRepository;
import com.example.securityv2.repository.RoleRepository;
import com.example.securityv2.repository.UserRepository;
import com.example.securityv2.service.BadgeService;
import com.example.securityv2.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @MockBean
    private BadgeService badgeService;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#getUsers()}
     */
    @Test
    void testGetUsers() throws Exception {
        when(this.userService.getUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#getUsers()}
     */
    @Test
    void testGetUsers2() throws Exception {
        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("?");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("?");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(this.userService.getUsers()).thenReturn(userList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":123,\"indeks\":1,\"nickname\":\"?\",\"password\":\"iloveyou\",\"icon\":\"?\",\"description\":\"The characteristics"
                                        + " of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked\":true,\"enabled"
                                        + "\":true}]"));
    }

    /**
     * Method under test: {@link UserController#getUsers()}
     */
    @Test
    void testGetUsers3() throws Exception {
        when(this.userService.getUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/users");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#saveUser(User)}
     */
    @Test
    void testSaveUser() throws Exception {
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
        when(this.userService.saveUser((User) any())).thenReturn(user);

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
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/user/save"));
    }

    /**
     * Method under test: {@link UserController#saveUser(User)}
     */
    @Test
    void testSaveUser2() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("?");

        ArrayList<Badge> badgeList = new ArrayList<>();
        badgeList.add(badge);

        User user = new User();
        user.setBadges(badgeList);
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
        when(this.userService.saveUser((User) any())).thenReturn(user);

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
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[{\"id\":123"
                                        + ",\"name\":\"?\"}],\"locked\":true,\"enabled\":true}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/user/save"));
    }

    /**
     * Method under test: {@link UserController#saveUser(User)}
     */
    @Test
    void testSaveUser3() throws Exception {
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
        when(this.userService.saveUser((User) any())).thenReturn(user);

        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("?");

        ArrayList<Badge> badgeList = new ArrayList<>();
        badgeList.add(badge);

        User user1 = new User();
        user1.setBadges(badgeList);
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
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/user/save"));
    }

    /**
     * Method under test: {@link UserController#updateUser(User)}
     */
    @Test
    void testUpdateUser() throws Exception {
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
        when(this.userService.updateUser((User) any())).thenReturn(user);

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
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}"));
    }

    /**
     * Method under test: {@link UserController#updateUser(User)}
     */
    @Test
    void testUpdateUser2() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("?");

        ArrayList<Badge> badgeList = new ArrayList<>();
        badgeList.add(badge);

        User user = new User();
        user.setBadges(badgeList);
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
        when(this.userService.updateUser((User) any())).thenReturn(user);

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
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[{\"id\":123"
                                        + ",\"name\":\"?\"}],\"locked\":true,\"enabled\":true}"));
    }

    /**
     * Method under test: {@link UserController#updateUser(User)}
     */
    @Test
    void testUpdateUser3() throws Exception {
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
        when(this.userService.updateUser((User) any())).thenReturn(user);

        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("?");

        ArrayList<Badge> badgeList = new ArrayList<>();
        badgeList.add(badge);

        User user1 = new User();
        user1.setBadges(badgeList);
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
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}"));
    }

    /**
     * Method under test: {@link UserController#deleteUser(Long)}
     */
    @Test
    void testDeleteUser() throws Exception {
        doNothing().when(this.userService).deleteUser((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/user/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#deleteUser(Long)}
     */
    @Test
    void testDeleteUser2() throws Exception {
        doNothing().when(this.userService).deleteUser((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/user/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#getRoles()}
     */
    @Test
    void testGetRoles() throws Exception {
        when(this.userService.getRoles()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/roles");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#getRoles()}
     */
    @Test
    void testGetRoles2() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("?");

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        when(this.userService.getRoles()).thenReturn(roleList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/roles");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":123,\"name\":\"?\"}]"));
    }

    /**
     * Method under test: {@link UserController#getRoles()}
     */
    @Test
    void testGetRoles3() throws Exception {
        when(this.userService.getRoles()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/roles");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#saveRole(Role)}
     */
    @Test
    void testSaveRole() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.userService.saveRole((Role) any())).thenReturn(role);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(role1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/role/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/role/save"));
    }

    /**
     * Method under test: {@link UserController#updateRole(Role)}
     */
    @Test
    void testUpdateRole() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.userService.updateRole((Role) any())).thenReturn(role);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(role1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/role/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link UserController#deleteRole(Long)}
     */
    @Test
    void testDeleteRole() throws Exception {
        doNothing().when(this.userService).deleteRole((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/role/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#deleteRole(Long)}
     */
    @Test
    void testDeleteRole2() throws Exception {
        doNothing().when(this.userService).deleteRole((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/role/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#addRoleToUser(RoleToUser)}
     */
    @Test
    void testAddRoleToUser() throws Exception {
        doNothing().when(this.userService).addRoleToUser((String) any(), (String) any());

        RoleToUser roleToUser = new RoleToUser();
        roleToUser.setEmail("jane.doe@example.org");
        roleToUser.setRolename("Rolename");
        String content = (new ObjectMapper()).writeValueAsString(roleToUser);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/role/addtouser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#addBadgeToUser(BadgeToUser)}
     */
    @Test
    void testAddBadgeToUser() throws Exception {
        doNothing().when(this.badgeService).addBadgeToUser((String) any(), (String) any());

        BadgeToUser badgeToUser = new BadgeToUser();
        badgeToUser.setBadgename("Badgename");
        badgeToUser.setEmail("jane.doe@example.org");
        String content = (new ObjectMapper()).writeValueAsString(badgeToUser);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/badge/addtouser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#refreshToken(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testRefreshToken() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: Refresh token is missing
        //       at com.example.securityv2.controller.UserController.refreshToken(UserController.java:134)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent refreshToken(HttpServletRequest, HttpServletResponse)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   refreshToken(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        RoleRepository roleRepository = mock(RoleRepository.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserService userService = new UserService(userRepository, roleRepository, passwordEncoder,
                new ConfirmationTokenService(mock(ConfirmationTokenRepository.class)));

        UserController userController = new UserController(userService,
                new BadgeService(mock(UserRepository.class), mock(BadgeRepository.class)));
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertThrows(RuntimeException.class, () -> userController.refreshToken(request, new Response()));
    }

    /**
     * Method under test: {@link UserController#refreshToken(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testRefreshToken2() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: Refresh token is missing
        //       at com.example.securityv2.controller.UserController.refreshToken(UserController.java:134)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent refreshToken(HttpServletRequest, HttpServletResponse)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   refreshToken(HttpServletRequest, HttpServletResponse).
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
        userService.addRoleToUser("jane.doe@example.org", "Authorization");
        UserController userController = new UserController(userService,
                new BadgeService(mock(UserRepository.class), mock(BadgeRepository.class)));
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertThrows(RuntimeException.class, () -> userController.refreshToken(request, new Response()));
        verify(userRepository).findByEmail((String) any());
        verify(roleRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link UserController#refreshToken(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRefreshToken3() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: Refresh token is missing
        //       at com.example.securityv2.controller.UserController.refreshToken(UserController.java:134)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent refreshToken(HttpServletRequest, HttpServletResponse)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   refreshToken(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletRequest.getHeader(String)" because "request" is null
        //       at com.example.securityv2.controller.UserController.refreshToken(UserController.java:104)
        //   In order to prevent refreshToken(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   refreshToken(HttpServletRequest, HttpServletResponse).
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
        userService.addRoleToUser("jane.doe@example.org", "Authorization");
        UserController userController = new UserController(userService,
                new BadgeService(mock(UserRepository.class), mock(BadgeRepository.class)));
        userController.refreshToken(null, new Response());
    }

    /**
     * Method under test: {@link UserController#getUserByEmail(String)}
     */
    @Test
    void testGetUserByEmail() throws Exception {
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
        when(this.userService.getUser((String) any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/find/{email}",
                "jane.doe@example.org");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}"));
    }

    /**
     * Method under test: {@link UserController#getUserByEmail(String)}
     */
    @Test
    void testGetUserByEmail2() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("?");

        ArrayList<Badge> badgeList = new ArrayList<>();
        badgeList.add(badge);

        User user = new User();
        user.setBadges(badgeList);
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
        when(this.userService.getUser((String) any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/find/{email}",
                "jane.doe@example.org");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[{\"id\":123"
                                        + ",\"name\":\"?\"}],\"locked\":true,\"enabled\":true}"));
    }

    /**
     * Method under test: {@link UserController#getUserByEmail(String)}
     */
    @Test
    void testGetUserByEmail3() throws Exception {
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
        when(this.userService.getUser((String) any())).thenReturn(user);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/user/find/{email}",
                "jane.doe@example.org");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"indeks\":1,\"nickname\":\"Nickname\",\"password\":\"iloveyou\",\"icon\":\"Icon\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"email\":\"jane.doe@example.org\",\"role\":[],\"badges\":[],\"locked"
                                        + "\":true,\"enabled\":true}"));
    }
}

