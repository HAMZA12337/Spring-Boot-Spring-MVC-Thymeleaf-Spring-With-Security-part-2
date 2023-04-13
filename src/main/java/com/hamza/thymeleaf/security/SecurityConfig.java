package com.hamza.thymeleaf.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

    return new InMemoryUserDetailsManager(

            User.withUsername("user1").password("{noop}1234").roles("User").build(),
            User.withUsername("user2").password("{noop}1234").roles("User").build(),
            User.withUsername("admin").password("{noop}1234").roles("User","ADMIN").build()



    );}






    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

     // autoriser un formulaire d'authentification

        httpSecurity.formLogin();
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
         return httpSecurity.build();}




}
