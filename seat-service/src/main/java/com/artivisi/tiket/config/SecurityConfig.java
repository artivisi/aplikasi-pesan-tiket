package com.artivisi.tiket.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String SQL_LOGIN = "select username, password, aktif as enabled from s_users where username=?";
    private static final String SQL_ROLE = "select u.username, p.nama as authority from s_users u inner join s_user_permission sp on u.id=sp.id_user inner join s_permission p on p.id=sp.id_permission where u.username=?";

    @Autowired private DataSource dataSource;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication()
        //    .withUser("endy").password("123").roles("USER");

        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(SQL_LOGIN)
            .authoritiesByUsernameQuery(SQL_ROLE);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/kereta/**").hasRole("VIEW_KERETA")
            .antMatchers("/seat/**").hasRole("VIEW_SEAT")
            .antMatchers("/booking/**").hasRole("CREATE_BOOKING")
            .anyRequest().authenticated()
            .and().formLogin()
            ;
    }
}
