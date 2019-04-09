package com.taiji.yuhongyue;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("1").password("1").roles("USER").build());
		manager.createUser(User.withUsername("2").password("2").roles("ADMIN").build());
		manager.createUser(User.withUsername("3").password("3").roles("DBA").build());
		manager.createUser(User.withUsername("4").password("4").roles("ADMIN", "DBA").build());
		return manager;
	}

	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/resources/**", "/signup", "/about","/login").permitAll().antMatchers("/admin/**")
				.hasRole("ADMIN").antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')").anyRequest()
				.authenticated();
		http.formLogin().loginPage("/login").successForwardUrl("/home").permitAll();
		//loginpage()方法是去controller端口里找
	}

}
