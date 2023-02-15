package com.oretania.portal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                // .password(passwordEncoder().encode("kaka"))
                .password("{noop}kaka")
                .authorities("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                // .password(passwordEncoder().encode("kaka"))
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .authorities("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(users());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    // @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
                .formLogin()
            .and()
                .httpBasic();

        return http.build();
    }
}