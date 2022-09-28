package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



import com.example.demo.service.Dbsdetailservice;



@Configuration
@EnableWebSecurity
public class Dbssecurityconfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    Dbsdetailservice dbsdetailservice;
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(dbsdetailservice);
         
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/admin").hasAuthority("admin")
        .antMatchers("/user").hasAnyAuthority("admin","user")
        .antMatchers("/home").permitAll()
        .and()
        .headers().frameOptions().disable()
        .and()
        .cors().disable()
        .formLogin();
    }



   @Bean
    public PasswordEncoder getPasswordEncode() {
        return NoOpPasswordEncoder.getInstance();
    }



}