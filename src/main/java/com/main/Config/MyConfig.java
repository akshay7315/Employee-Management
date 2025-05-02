package com.main.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/login", "/register").permitAll() // Allow access to login and register pages
                    .requestMatchers("/project").authenticated() // Only authenticated users can access the project page
                    .anyRequest().authenticated() // Any other requests require authentication
                )
                .formLogin(form -> form
                    .loginPage("/login") // Custom login page
                    .permitAll()
                    .defaultSuccessUrl("/project", true) // After successful login, redirect to project page
                )
                .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login") // Redirect to login after logout
                )
                .build();
    }
}
