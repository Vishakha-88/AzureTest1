package com.test.demo.security;

import com.azure.spring.cloud.autoconfigure.aadb2c.AadB2cOidcLoginConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	    private final AadB2cOidcLoginConfigurer configurer;

	    public WebSecurityConfiguration(AadB2cOidcLoginConfigurer configurer) {
	        this.configurer = configurer;
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .apply(configurer)
	        ;
	    }
	}

