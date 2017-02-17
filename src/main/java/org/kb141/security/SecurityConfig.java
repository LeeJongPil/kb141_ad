package org.kb141.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// public static final String REMEMBER_ME_KEY = "REMEMBER_ME";

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	// 1.2. http 설정
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/ad/cendlog").permitAll()
				.antMatchers("/admin/**")
				.hasRole("ADMIN")
				.antMatchers("/client/**")
				.hasAnyRole("CLIENT", "ADMIN");
		// .anyRequest().authenticated()

		http.formLogin().loginPage("/login").successHandler(customSuccessHandler).permitAll();

		http.rememberMe().key("REMEMBER_KEY").rememberMeParameter("_spring_security_remember_me")
				.rememberMeCookieName("REMEMBER").tokenValiditySeconds(60000);

		String[] cookies = { "JSESSIONID", "username", "REMEMBER","urlname" };
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies(cookies);
	}
	
	
	
	// @Bean
	// public TokenBasedRememberMeServices tokenBasedRememberMeServices(){
	// TokenBasedRememberMeServices tokenBasedRememberMeServices =
	// new TokenBasedRememberMeServices(REMEMBER_ME_KEY, userDetailsService);
	// tokenBasedRememberMeServices.setCookieName("REMEMBER");
	// return tokenBasedRememberMeServices;
	// }

	// // 1.1. 인메모리 설정
	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth
	// .inMemoryAuthentication()
	// .withUser("admin").password("1234").roles("ADMIN");
	// }
	//
	//
	// protected void configure(HttpSecurity http) throws Exception{
	// http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
	// .antMatchers("/**").permitAll().and().formLogin().loginPage("/login").permitAll();
	//
	// }

}