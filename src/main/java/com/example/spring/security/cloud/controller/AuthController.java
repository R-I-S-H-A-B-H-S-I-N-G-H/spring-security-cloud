package com.example.spring.security.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.cloud.model.AuthRequest;
import com.example.spring.security.cloud.model.AuthResponse;
import com.example.spring.security.cloud.security.UserDetailServiceImpl;
import com.example.spring.security.cloud.service.config.util.JwtUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    // @PostMapping("")
    // String createAuthToken(@RequestBody AuthRequest authRequest) {
    // return "HELLO";
    // }

    @PostMapping("")
    ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest)
            throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                            authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("INCORRECT PASS OR USER NAME : ", e);
        }
        final UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
