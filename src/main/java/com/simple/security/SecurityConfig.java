package com.simple.security;

import com.simple.auth.CustomAuthenticationEntryPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
       //@formatter:off
       http
           .csrf().disable()
           .authorizeRequests()
           .antMatchers("/public", "/public/**").permitAll()
           .antMatchers("/api/**").authenticated()
           .and()
           .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
           .and()
           .httpBasic()
           .authenticationEntryPoint(authEntryPoint);
     //@formatter:on
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
         * ADD CUSTOM AUTHENTICATION PROVIDER HERE
         * auth.userDetailsService(userDetailsService)
         *
        **/
        //@formatter:off
        auth.inMemoryAuthentication()
          .withUser("user").password(passwordEncoder().encode("user")).authorities("ROLE_USER")
          .and()
          .withUser("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_ADMIN");
        //@formatter:on
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
