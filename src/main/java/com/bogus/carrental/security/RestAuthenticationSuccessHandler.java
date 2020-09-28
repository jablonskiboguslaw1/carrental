package com.bogus.carrental.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final long expirationTime;
    private final String secret;

    public RestAuthenticationSuccessHandler(@Value("${jwt.expirationTime}") long expirationTime, @Value("${jwt.secret}") String secret) {
        this.expirationTime = expirationTime;
        this.secret = secret;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secret));
        response.getOutputStream().print("{" +
                "\"id\": \"" + principal.getId() + "\",\n" +
                "\"name\": \"" + principal.getName() + "\",\n" +
                "\"surname\": \"" + principal.getSurname() + "\",\n" +
                "\"username\": \"" + principal.getUsername() + "\",\n" +
                "\"roles\": " + principal.getAuthorities().stream().map(l -> "\"" + l + "\"").collect(Collectors.toList()) + ",\n" +
                "\"accessToken\": \"" + token + "\"}");

        //  response.addHeader("Authorization", "Bearer " + token);
    }
}
