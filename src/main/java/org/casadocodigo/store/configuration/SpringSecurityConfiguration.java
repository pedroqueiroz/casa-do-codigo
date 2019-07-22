package org.casadocodigo.store.configuration;

import org.casadocodigo.store.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDAO userDAO;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/products/form").hasRole("ADMIN")
            .antMatchers("/cart").permitAll()
            .antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/products").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/products/").hasRole("ADMIN")
            .antMatchers("/products/**").permitAll()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDAO)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
}
