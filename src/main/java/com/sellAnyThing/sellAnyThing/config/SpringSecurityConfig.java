package com.sellAnyThing.sellAnyThing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {


    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("#cXvw46$0F^b")
                .password(encoder.encode("RsmY$eacj^U*hO2CcpARU6^Pk!RPjxR*huN#4Hf*Z9gI2IO0ia"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("bXg23GuuN@1@")
                .password(encoder.encode("S3Ng7IHiw9r30fVwm8Xo%!Dex59ho^8*kAmB6ZKWJs25x@eU1$"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();

    }
}
