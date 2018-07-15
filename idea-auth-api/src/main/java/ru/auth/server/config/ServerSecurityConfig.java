package ru.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    public ServerSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)     throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("$2a$10$mritUNcLpmJ.HTzVwrb4JuZ9b6RX6Wiu57JgKgdcjJMod5WqpAQxy").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*   http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests().
                and().formLogin().permitAll();*/
        http
                .authorizeRequests().mvcMatchers("/login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
