package com.example.securityv2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.Role;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.BadRequestException;
import com.example.securityv2.registration.token.ConfirmationTokenService;
import com.example.securityv2.repository.RoleRepository;
import com.example.securityv2.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private ConfirmationTokenService confirmationTokenService;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#addRoleToUser(String, String)}
     */
    @Test
    void testAddRoleToUser() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.roleRepository.findByName((String) any())).thenReturn(role);
        this.userService.addRoleToUser("jane.doe@example.org", "Role Name");
        verify(this.userRepository).findByEmail((String) any());
        verify(this.roleRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link UserService#addRoleToUser(String, String)}
     */
    @Test
    void testAddRoleToUser2() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.roleRepository.findByName((String) any())).thenThrow(new BadRequestException("An error occurred"));
        assertThrows(BadRequestException.class, () -> this.userService.addRoleToUser("jane.doe@example.org", "Role Name"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.roleRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link UserService#addRoleToUser(String, String)}
     */
    @Test
    void testAddRoleToUser3() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.roleRepository.findByName((String) any())).thenReturn(role);
        assertThrows(UsernameNotFoundException.class,
                () -> this.userService.addRoleToUser("jane.doe@example.org", "Role Name"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#getUsers()}
     */
    @Test
    void testGetUsers() {
        ArrayList<User> userList = new ArrayList<>();
        when(this.userRepository.findAll()).thenReturn(userList);
        List<User> actualUsers = this.userService.getUsers();
        assertSame(userList, actualUsers);
        assertTrue(actualUsers.isEmpty());
        verify(this.userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getUsers()}
     */
    @Test
    void testGetUsers2() {
        when(this.userRepository.findAll()).thenThrow(new BadRequestException("An error occurred"));
        assertThrows(BadRequestException.class, () -> this.userService.getUsers());
        verify(this.userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getUser(String)}
     */
    @Test
    void testGetUser() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        assertSame(user, this.userService.getUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#getUser(String)}
     */
    @Test
    void testGetUser2() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> this.userService.getUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#getUser(String)}
     */
    @Test
    void testGetUser3() {
        when(this.userRepository.findByEmail((String) any())).thenThrow(new BadRequestException("An error occurred"));
        assertThrows(BadRequestException.class, () -> this.userService.getUser("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#saveUser(User)}
     */
    @Test
    void testSaveUser() {
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
        Optional<User> ofResult = Optional.of(user1);
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Icon");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Nickname");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        assertThrows(BadRequestException.class, () -> this.userService.saveUser(user2));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#saveUser(User)}
     */
    @Test
    void testSaveUser2() {
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
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());

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
        assertSame(user, this.userService.saveUser(user1));
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#saveUser(User)}
     */
    @Test
    void testSaveUser3() {
        when(this.userRepository.save((User) any())).thenThrow(new IllegalStateException("Saving new user {}"));
        when(this.userRepository.findByEmail((String) any())).thenThrow(new IllegalStateException("Saving new user {}"));

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
        assertThrows(IllegalStateException.class, () -> this.userService.saveUser(user));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(User)}
     */
    @Test
    void testUpdateUser() {
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
        when(this.userRepository.save((User) any())).thenReturn(user);

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
        assertSame(user, this.userService.updateUser(user1));
        verify(this.userRepository).save((User) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(User)}
     */
    @Test
    void testUpdateUser2() {
        when(this.userRepository.save((User) any())).thenThrow(new BadRequestException("An error occurred"));

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
        assertThrows(BadRequestException.class, () -> this.userService.updateUser(user));
        verify(this.userRepository).save((User) any());
    }

    /**
     * Method under test: {@link UserService#deleteUser(Long)}
     */
    @Test
    void testDeleteUser() {
        doNothing().when(this.userRepository).deleteById((Long) any());
        this.userService.deleteUser(123L);
        verify(this.userRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link UserService#deleteUser(Long)}
     */
    @Test
    void testDeleteUser2() {
        doThrow(new BadRequestException("An error occurred")).when(this.userRepository).deleteById((Long) any());
        assertThrows(BadRequestException.class, () -> this.userService.deleteUser(123L));
        verify(this.userRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link UserService#getUsersWithPaggination(int, int)}
     */
    @Test
    void testGetUsersWithPaggination() {
        PageImpl<User> pageImpl = new PageImpl<>(new ArrayList<>());
        when(this.userRepository.findAll((org.springframework.data.domain.Pageable) any())).thenReturn(pageImpl);
        Page<User> actualUsersWithPaggination = this.userService.getUsersWithPaggination(2, 3);
        assertSame(pageImpl, actualUsersWithPaggination);
        assertTrue(actualUsersWithPaggination.toList().isEmpty());
        verify(this.userRepository).findAll((org.springframework.data.domain.Pageable) any());
    }

    /**
     * Method under test: {@link UserService#getUsersWithPaggination(int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsersWithPaggination2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Page index must not be less than zero!
        //       at org.springframework.data.domain.AbstractPageRequest.<init>(AbstractPageRequest.java:44)
        //       at org.springframework.data.domain.PageRequest.<init>(PageRequest.java:45)
        //       at org.springframework.data.domain.PageRequest.of(PageRequest.java:72)
        //       at org.springframework.data.domain.PageRequest.of(PageRequest.java:60)
        //       at com.example.securityv2.service.UserService.getUsersWithPaggination(UserService.java:78)
        //   In order to prevent getUsersWithPaggination(int, int)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getUsersWithPaggination(int, int).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.userRepository.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        this.userService.getUsersWithPaggination(-1, 3);
    }

    /**
     * Method under test: {@link UserService#getUsersWithPaggination(int, int)}
     */
    @Test
    void testGetUsersWithPaggination3() {
        when(this.userRepository.findAll((org.springframework.data.domain.Pageable) any()))
                .thenThrow(new BadRequestException("An error occurred"));
        assertThrows(BadRequestException.class, () -> this.userService.getUsersWithPaggination(2, 3));
        verify(this.userRepository).findAll((org.springframework.data.domain.Pageable) any());
    }

    /**
     * Method under test: {@link UserService#getRoles()}
     */
    @Test
    void testGetRoles() {
        ArrayList<Role> roleList = new ArrayList<>();
        when(this.roleRepository.findAll()).thenReturn(roleList);
        List<Role> actualRoles = this.userService.getRoles();
        assertSame(roleList, actualRoles);
        assertTrue(actualRoles.isEmpty());
        verify(this.roleRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getRoles()}
     */
    @Test
    void testGetRoles2() {
        when(this.roleRepository.findAll()).thenThrow(new BadRequestException("An error occurred"));
        assertThrows(BadRequestException.class, () -> this.userService.getRoles());
        verify(this.roleRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getRole(String)}
     */
    @Test
    void testGetRole() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.roleRepository.findByName((String) any())).thenReturn(role);
        assertSame(role, this.userService.getRole("Name"));
        verify(this.roleRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link UserService#getRole(String)}
     */
    @Test
    void testGetRole2() {
        when(this.roleRepository.findByName((String) any())).thenThrow(new BadRequestException("An error occurred"));
        assertThrows(BadRequestException.class, () -> this.userService.getRole("Name"));
        verify(this.roleRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link UserService#saveRole(Role)}
     */
    @Test
    void testSaveRole() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.roleRepository.save((Role) any())).thenReturn(role);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertSame(role, this.userService.saveRole(role1));
        verify(this.roleRepository).save((Role) any());
    }

    /**
     * Method under test: {@link UserService#saveRole(Role)}
     */
    @Test
    void testSaveRole2() {
        when(this.roleRepository.save((Role) any())).thenThrow(new BadRequestException("An error occurred"));

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        assertThrows(BadRequestException.class, () -> this.userService.saveRole(role));
        verify(this.roleRepository).save((Role) any());
    }

    /**
     * Method under test: {@link UserService#updateRole(Role)}
     */
    @Test
    void testUpdateRole() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.roleRepository.save((Role) any())).thenReturn(role);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertSame(role, this.userService.updateRole(role1));
        verify(this.roleRepository).save((Role) any());
    }

    /**
     * Method under test: {@link UserService#updateRole(Role)}
     */
    @Test
    void testUpdateRole2() {
        when(this.roleRepository.save((Role) any())).thenThrow(new BadRequestException("An error occurred"));

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        assertThrows(BadRequestException.class, () -> this.userService.updateRole(role));
        verify(this.roleRepository).save((Role) any());
    }

    /**
     * Method under test: {@link UserService#deleteRole(Long)}
     */
    @Test
    void testDeleteRole() {
        doNothing().when(this.roleRepository).deleteById((Long) any());
        this.userService.deleteRole(123L);
        verify(this.roleRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link UserService#deleteRole(Long)}
     */
    @Test
    void testDeleteRole2() {
        doThrow(new BadRequestException("An error occurred")).when(this.roleRepository).deleteById((Long) any());
        assertThrows(BadRequestException.class, () -> this.userService.deleteRole(123L));
        verify(this.roleRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link UserService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.userService.loadUserByUsername("jane.doe@example.org");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Cannot pass null or empty values to constructor
        //       at org.springframework.util.Assert.isTrue(Assert.java:121)
        //       at org.springframework.security.core.userdetails.User.<init>(User.java:110)
        //       at org.springframework.security.core.userdetails.User.<init>(User.java:87)
        //       at com.example.securityv2.service.UserService.loadUserByUsername(UserService.java:117)
        //   In order to prevent loadUserByUsername(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getEmail()).thenReturn("");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getRole()).thenReturn(new ArrayList<>());
        doNothing().when(user).setBadges((java.util.Collection<Badge>) any());
        doNothing().when(user).setDescription((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setEnabled((Boolean) any());
        doNothing().when(user).setIcon((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setIndeks(anyInt());
        doNothing().when(user).setLocked((Boolean) any());
        doNothing().when(user).setNickname((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((java.util.Collection<Role>) any());
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        this.userService.loadUserByUsername("jane.doe@example.org");
    }

    /**
     * Method under test: {@link UserService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        User user = mock(User.class);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getRole()).thenReturn(roleList);
        doNothing().when(user).setBadges((Collection<Badge>) any());
        doNothing().when(user).setDescription((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setEnabled((Boolean) any());
        doNothing().when(user).setIcon((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setIndeks(anyInt());
        doNothing().when(user).setLocked((Boolean) any());
        doNothing().when(user).setNickname((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Collection<Role>) any());
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.userService.loadUserByUsername("jane.doe@example.org");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepository).findByEmail((String) any());
        verify(user).getEmail();
        verify(user).getPassword();
        verify(user).getRole();
        verify(user).setBadges((Collection<Badge>) any());
        verify(user).setDescription((String) any());
        verify(user).setEmail((String) any());
        verify(user).setEnabled((Boolean) any());
        verify(user).setIcon((String) any());
        verify(user).setId((Long) any());
        verify(user).setIndeks(anyInt());
        verify(user).setLocked((Boolean) any());
        verify(user).setNickname((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Collection<Role>) any());
    }

    /**
     * Method under test: {@link UserService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        User user = mock(User.class);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getRole()).thenReturn(new ArrayList<>());
        doNothing().when(user).setBadges((java.util.Collection<Badge>) any());
        doNothing().when(user).setDescription((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setEnabled((Boolean) any());
        doNothing().when(user).setIcon((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setIndeks(anyInt());
        doNothing().when(user).setLocked((Boolean) any());
        doNothing().when(user).setNickname((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((java.util.Collection<Role>) any());
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
        assertThrows(UsernameNotFoundException.class, () -> this.userService.loadUserByUsername("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
        verify(user).setBadges((java.util.Collection<Badge>) any());
        verify(user).setDescription((String) any());
        verify(user).setEmail((String) any());
        verify(user).setEnabled((Boolean) any());
        verify(user).setIcon((String) any());
        verify(user).setId((Long) any());
        verify(user).setIndeks(anyInt());
        verify(user).setLocked((Boolean) any());
        verify(user).setNickname((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((java.util.Collection<Role>) any());
    }

    /**
     * Method under test: {@link UserService#signUpUser(User)}
     */
    @Test
    void testSignUpUser() {
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
        Optional<User> ofResult = Optional.of(user1);
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setBadges(new ArrayList<>());
        user2.setDescription("The characteristics of someone or something");
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setIcon("Icon");
        user2.setId(123L);
        user2.setIndeks(1);
        user2.setLocked(true);
        user2.setNickname("Nickname");
        user2.setPassword("iloveyou");
        user2.setRole(new ArrayList<>());
        assertThrows(IllegalStateException.class, () -> this.userService.signUpUser(user2));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#signUpUser(User)}
     */
    @Test
    void testSignUpUser2() {
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
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());

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
        assertThrows(UsernameNotFoundException.class, () -> this.userService.signUpUser(user1));
        verify(this.userRepository).save((User) any());
        verify(this.userRepository, atLeast(1)).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#signUpUser(User)}
     */
    @Test
    void testSignUpUser3() {
        when(this.userRepository.save((User) any())).thenThrow(new IllegalStateException("Saving new user {}"));
        when(this.userRepository.findByEmail((String) any())).thenThrow(new IllegalStateException("Saving new user {}"));

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
        assertThrows(IllegalStateException.class, () -> this.userService.signUpUser(user));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#enableUser(String)}
     */
    @Test
    void testEnableUser() {
        when(this.userRepository.enableUser((String) any())).thenReturn(1);
        assertEquals(1, this.userService.enableUser("jane.doe@example.org"));
        verify(this.userRepository).enableUser((String) any());
    }

    /**
     * Method under test: {@link UserService#enableUser(String)}
     */
    @Test
    void testEnableUser2() {
        when(this.userRepository.enableUser((String) any())).thenThrow(new BadRequestException("An error occurred"));
        assertThrows(BadRequestException.class, () -> this.userService.enableUser("jane.doe@example.org"));
        verify(this.userRepository).enableUser((String) any());
    }
}

