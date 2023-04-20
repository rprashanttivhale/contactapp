package com.employeedetails.Contact.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class ContactSecurityConfig extends WebSecurityConfigurerAdapter{ @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER")
            .and()
            .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

}

// Secure the endpoins with HTTP Basic authentication
@Override
protected void configure(HttpSecurity http) throws Exception {

    http
            //HTTP Basic authentication
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/getAllEmployee/**").hasRole("USER")
            .antMatchers(HttpMethod.POST, "/employee/addEmployee").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/employee/updateEmployee").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/employee/deleteEmployeeById/**").hasRole("ADMIN")
            .and()
            .csrf().disable()
            .formLogin().disable();
}
}
