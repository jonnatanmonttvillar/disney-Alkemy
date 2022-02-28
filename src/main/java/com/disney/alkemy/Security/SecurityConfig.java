package com.disney.alkemy.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bcrypt;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) 
        throws Exception {
            auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bcrypt);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            .antMatchers(HttpMethod.POST,"/user/signup").permitAll()
            .antMatchers(HttpMethod.GET,"/user/login/{id_usuario}").permitAll()
            .anyRequest().authenticated();
    }

}
