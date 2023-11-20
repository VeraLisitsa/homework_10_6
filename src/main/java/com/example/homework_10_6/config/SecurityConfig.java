package com.example.homework_10_6.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("User1").password("{noop}password").authorities("read", "write")
                .and()
                .withUser("User2").password("{noop}password").roles("READ")
                .and()
                .withUser("User3").password("{noop}password").roles("WRITE")
                .and()
                .withUser("User4").password("{noop}password").roles("READ", "WRITE", "DELETE");

    }

}
