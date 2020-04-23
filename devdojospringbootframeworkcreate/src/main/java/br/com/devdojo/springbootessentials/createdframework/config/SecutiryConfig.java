package br.com.devdojo.springbootessentials.createdframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.devdojo.springbootessentials.createdframework.service.CustomUserDetailsService;

/**
 * 
 * @author ferreira
 * @since 06/04/2020 
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // filter authorization for method
public class SecutiryConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Access to any method - authentication
//		http.authorizeRequests().anyRequest().authenticated()
//		.and().httpBasic()
//		.and().csrf().disable(); //CSRF used for false request
		/*
		 * USER and ADMIN permission access filter
		 */
		http.authorizeRequests()
		.antMatchers("/*/admin/**").hasRole("ADMIN")
		.antMatchers("/*/default/**").hasRole("USER")
		.and()
		.httpBasic()
		.and()
		.csrf().disable(); //CSRF used for false request
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	// authentication - access endPoint - used access in memory
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("damiao")
//		.password("{noop}1234").roles("USER").and().withUser("admin").password("{noop}1234")
//		.roles("USER", "ADMIN");
//	}
}
