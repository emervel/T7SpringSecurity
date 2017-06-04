package com.emervel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by guopm on 03/06/2017.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true) //para anadir anotaciones de seguridad a metodos de requets para asi permitir o no acceder a los mappings
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
