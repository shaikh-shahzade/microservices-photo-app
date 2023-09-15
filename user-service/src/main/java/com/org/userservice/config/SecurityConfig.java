package com.org.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.net.http.HttpRequest;

@Configuration
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.csrf().disable()
                .authorizeHttpRequests
                (authorize->{
                    try {
                        authorize.antMatchers(HttpMethod.POST , "/user" )

                                .permitAll()
                                .antMatchers("/actuator/*")
                                .permitAll()
                                .anyRequest()
                                .authenticated()

                                .and()
                                .httpBasic(Customizer.withDefaults());
                        http.sessionManagement()
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    ;
                });
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
}
