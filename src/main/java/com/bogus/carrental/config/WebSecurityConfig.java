package com.bogus.carrental.config;

import com.bogus.carrental.controllers.JsonObjectAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    private ObjectMapper objectMapper;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        auth.jdbcAuthentication().dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()

                .antMatchers(HttpMethod.GET, "/client").permitAll()
                .antMatchers(HttpMethod.GET, "/employee").hasAuthority("MANAGER")
                .antMatchers(HttpMethod.GET, "/cars").permitAll()
                .antMatchers(HttpMethod.POST, "/cars").permitAll()//hasAuthority("CLIENT")
                .antMatchers(HttpMethod.GET, "/department").hasAuthority("EMPLOYEE")

                .anyRequest().authenticated()
                .and()
                .addFilter(authenticationFilter())

                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }
    @Bean
    public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
        JsonObjectAuthenticationFilter filter = new JsonObjectAuthenticationFilter(objectMapper);


        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler); // 1
        filter.setAuthenticationFailureHandler(authenticationFailureHandler); // 2

        filter.setAuthenticationManager(super.authenticationManager()); // 3
        return filter;
    }


}