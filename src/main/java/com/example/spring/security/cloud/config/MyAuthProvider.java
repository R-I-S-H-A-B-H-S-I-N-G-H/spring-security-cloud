package com.example.spring.security.cloud.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String pass = auth.getCredentials().toString();
        if (!"helix".equals(username))
            throw new BadCredentialsException("INVALID Username");
        if (!"test".equals(pass))
            throw new BadCredentialsException("INVALID Password");

        return new UsernamePasswordAuthenticationToken(username, pass, List.of());
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}