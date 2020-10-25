package com.bogus.carrental.config;

import com.bogus.carrental.security.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SecurityService securityService;
    private final ObjectMapper objectMapper;
    private final RestAuthenticationSuccessHandler authenticationSuccessHandler;
    private final RestAuthenticationFailureHandler authenticationFailureHandler;
    private final String secret;

    public WebSecurityConfig(SecurityService securityService, ObjectMapper objectMapper, RestAuthenticationSuccessHandler authenticationSuccessHandler, RestAuthenticationFailureHandler authenticationFailureHandler, @Value("${jwt.secret}") String secret) {
        this.objectMapper = objectMapper;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.secret = secret;
        this.securityService = securityService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers(HttpMethod.POST, "/cars").hasAuthority("MANAGER")
                .antMatchers(HttpMethod.PUT, "/cars").hasAuthority("MANAGER")
                .antMatchers(HttpMethod.POST, "/cars/**").hasAuthority("MANAGER")
                .antMatchers(HttpMethod.GET, "/employee").hasAnyAuthority("MANAGER", "EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/employee").hasAnyAuthority("MANAGER")
                .antMatchers(HttpMethod.PUT, "/employee/**").hasAnyAuthority("MANAGER")
                .antMatchers(HttpMethod.GET, "/department").hasAnyAuthority("MANAGER", "EMPLOYEE")
                .antMatchers("/reservation").authenticated()
                .antMatchers("/reservation/**").authenticated()
                .antMatchers("/rentals").authenticated()
                .antMatchers("/rental/**").authenticated()
                .antMatchers("/returns").authenticated()
                .antMatchers("/returns/**").authenticated()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/client").permitAll()
                .antMatchers("/client/**").hasAuthority("MANAGER")
                .antMatchers("/client/username/**").hasAuthority("MANAGER")
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().formLogin().permitAll().and().addFilter(authenticationFilter())
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), securityService, secret)).exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }

    @Bean
    public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
        JsonObjectAuthenticationFilter filter = new JsonObjectAuthenticationFilter(objectMapper);
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }




}
