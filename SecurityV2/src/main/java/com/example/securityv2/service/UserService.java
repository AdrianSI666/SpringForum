package com.example.securityv2.service;

import com.example.securityv2.domain.Role;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.BadRequestException;
import com.example.securityv2.registration.token.ConfirmationToken;
import com.example.securityv2.registration.token.ConfirmationTokenService;
import com.example.securityv2.repository.RoleRepository;
import com.example.securityv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    public void addRoleToUser(String email, String roleName) {
        log.info("Saving new role {} to user {}",roleName,email);
        User user=userRepository.findByEmail(email).orElseThrow(()->
            new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
        Role role=roleRepository.findByName(roleName);
        user.getRole().add(role);
    }

    public List<User> getUsers() {
        log.info("Getting all users");
        return userRepository.findAll();
    }

    public User getUser(String email) {
        log.info("Getting user {}",email);
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public User saveUser(User user) {
        Boolean existEmail = userRepository.findByEmail(user.getEmail()).isPresent();
        if(existEmail){
            throw new BadRequestException(
                    "Email " + user.getEmail() + " already taken"
            );
        }
        log.info("Saving new user {}",user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    public Page<User> getUsersWithPaggination(int offset, int pageSize) {
        log.info("Getting page of users");
        return userRepository.findAll(PageRequest.of(offset,pageSize));
    }

    public List<Role> getRoles() {
        log.info("Getting roles");
        return roleRepository.findAll();
    }

    public Role getRole(String name) {
        log.info("Getting role");
        return roleRepository.findByName(name);
    }

    public Role saveRole(Role role) {
        log.info("Saving new role {}",role.getName());
        return roleRepository.save(role);
    }

    public Role updateRole(Role role){
        return roleRepository.save(role);
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
        if(user==null){
            log.info(String.format(USER_NOT_FOUND_MSG, email));
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
        }
        else {
            log.info("User found in database: {}",email);
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRole().forEach(role-> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }

    public String signUpUser(User user) {
        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }


        saveUser(user);
        addRoleToUser(user.getEmail(),"User");
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);


        return token;
    }

    public int enableUser(String email) {
        log.info("Enabling user {}", email);
        return userRepository.enableUser(email);
    }

    public int getRating(String email){
        User user=userRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
        log.info("Getting ratings from trains with user: {}", email);
        int trainRating=userRepository.getTrainsRating(email).orElseGet(()->0);
        log.info("Getting ratings from comments with user: {}", email);
        int commentsRating=userRepository.getCommentariesRating(email).orElseGet(()->0);
        return trainRating+commentsRating;
    }
}
