package com.example.spring.security.cloud.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.spring.security.cloud.filters.JwtRequestFilter;
import com.example.spring.security.cloud.security.UserDetailServiceImpl;

@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http
                .csrf()
                .disable()
                .authorizeRequests()
                .mvcMatchers("/authenticate")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter,
                UsernamePasswordAuthenticationFilter.class);

        // http
        // .csrf()
        // .disable()
        // .authorizeRequests()
        // .mvcMatchers(HttpMethod.GET, "/**")
        // .hasAnyAuthority("USER", "ADMIN")
        // .mvcMatchers(HttpMethod.POST, "/**")
        // .hasAnyAuthority("ADMIN")
        // .anyRequest().permitAll();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        // return new Super
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
