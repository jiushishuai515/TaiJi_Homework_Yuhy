package com.taiji.yuhongyue;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomLogoutSuccessHandler customLogoutSuccessHandler;

	@Autowired
	private DataSource dataSource;

	// @Bean
	// public UserDetailsService userDetailsService() {
	// InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	// manager.createUser(User.withUsername("1").password("1").roles("USER").build());
	// manager.createUser(User.withUsername("2").password("2").roles("ADMIN").build());
	// manager.createUser(User.withUsername("3").password("3").roles("DBA").build());
	// manager.createUser(User.withUsername("4").password("4").roles("ADMIN",
	// "DBA").build());
	// return manager;
	// }

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// auth.inMemoryAuthentication().withUser("1").password("1").roles("USER").and().withUser("2").password("2")
		// .roles("ADMIN").and().withUser("3").password("3").roles("DBA").and().withUser("4").password("4")
		// .roles("ADMIN", "DBA");

		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
				.withUser("1").password("1").roles("USER")
				.and().withUser("2").password("2").roles("ADMIN")
				.and().withUser("3").password("3").roles("DBA")
				.and().withUser("4").password("4").roles("ADMIN", "DBA");
	}

	protected void configure(HttpSecurity http) throws Exception {

		// 禁用csrf防护
		http.csrf().ignoringAntMatchers("/h2-console/**");
		// 允许同源
		http.headers().frameOptions().sameOrigin();

		http.authorizeRequests().antMatchers("/resources/**", "/signup", "/about", "/login", "/h2-console").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/db/**")
				.access("hasRole('ADMIN') and hasRole('DBA')").anyRequest().authenticated();
		http.formLogin().loginPage("/login").usernameParameter("un").passwordParameter("pass").permitAll();
		// .successForwardUrl("/home")
		// .usernameParameter("uname")自定义用户名不改默认是username
		// .passwordParameter("pass")自定义密码不改模式是password 相应的form表单的用户名和密码要改
		// .successForwardUrl("/home")
		// loginpage()方法是去controller端口里找
		// .loginProcessingUrl(loginProcessingUrl)来设置security处理login的映射

		http.logout().logoutUrl("/logout")
				// handler优先级最大 有了他successURL就不生效了
				.logoutSuccessHandler(customLogoutSuccessHandler).invalidateHttpSession(true)
				.deleteCookies("SECURITYCOOKIE");

	}

}
