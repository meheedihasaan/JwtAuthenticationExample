package com.jwt.jwtauthenticationexample.config;

import com.jwt.jwtauthenticationexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username-> this.userRepository.findByEmail(username)
                            .orElseThrow(()-> new UsernameNotFoundException("User not found."));
    }

}
