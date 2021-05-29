package com.studenci.apkameta.security;


import com.studenci.apkameta.users.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("haslo")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("haslo1")).roles("ADMIN");
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/authorize").anonymous()
                .antMatchers("/modules").anonymous()
                .antMatchers("/reg").permitAll()
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/console/**").permitAll()
                .antMatchers("/DHL/**").permitAll()
                .antMatchers("/GLS/**").permitAll()
                .anyRequest().authenticated();
        // ...
    }
}
