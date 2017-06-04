package com.emervel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 * Created by guopm on 03/06/2017.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
//para anadir anotaciones de seguridad a metodos de requets para asi permitir o no acceder a los mappings
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        /*Para ponerlo directamente en memoria sin BBDD
        auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER").
                and().withUser("emervel").password("pass").roles("ADMIN");
        */

        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/posts/list").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        .and().formLogin()
        .and().logout();*/
        http.authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").usernameParameter("email").permitAll()
                .and()
                    .logout().logoutSuccessUrl("/login?Logout")
                .permitAll();
    }
}
