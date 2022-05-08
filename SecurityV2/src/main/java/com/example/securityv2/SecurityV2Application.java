package com.example.securityv2;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.Role;
import com.example.securityv2.domain.User;
import com.example.securityv2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class SecurityV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityV2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService){
        return args -> {
            /*userService.saveRole(new Role(null,"User"));
            userService.saveRole(new Role(null,"Admin"));
            userService.saveUser(new User(19333,"ania","ania",null,"wdym","ania@test.pl",new ArrayList<Role>(),new ArrayList<Badge>()));
            userService.addRoleToUser("ania@test.pl","User");
            userService.saveUser(new User(19426,"adrian","adrian",null,"iwtd","adrian@test.pl",new ArrayList<Role>(),new ArrayList<Badge>()));
            userService.addRoleToUser("adrian@test.pl","Admin");
            userService.enableUser("ania@test.pl");
            userService.enableUser("adrian@test.pl");*/
            /*userService.saveUser(new User(null,19426,"adrian","adrian",null,"wdym","adrian",new ArrayList<Role>()));
            userService.addRoleToUser("adrian","Admin");*/
        };
    }



}
