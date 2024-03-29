package ru.vitaly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Vitaly Vasilyev, e-mail: rav.energ@rambler.ru
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("admin").password(encoder.encode("ad")).roles("ADMIN")
                .and()
                .withUser("user").password(encoder.encode("us")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/main").authenticated()
                .antMatchers("/post/{id}/details").authenticated()
                .antMatchers(HttpMethod.GET, "/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/create/savepost").hasRole("ADMIN")
                .anyRequest().permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/main")

                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}