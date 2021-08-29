package be.icc.pid.reservationsSpringBoot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

public class SecurityConfiguration {


    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        UserDetailsService userDetailsService;
        @Autowired
        private DataSource dataSource;
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            PasswordEncoder passwordEncoder = passwordEncoder ();

            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder);

        }

         protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/artists/create").hasAnyRole("ADMIN");
            http.authorizeRequests().anyRequest().authenticated();
            http.formLogin();
        }

        @Bean
        public PasswordEncoder passwordEncoder(){

            return new BCryptPasswordEncoder();

        }
    }

}
