package com.blackcoffer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	
	/*---------------------------------------   Spring Security Filter -------------------------------------------*/	

	@Bean
	public SecurityFilterChain SecurityFilter(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests( (auth)->auth
				.antMatchers("/blackcoffer/user/home").authenticated()
				.antMatchers("/course/**", "/student/**").hasRole("admin")
				.antMatchers("/blackcoffer/user/register").permitAll()
				
		).csrf().disable()
		.httpBasic();
		
		
		return httpSecurity.build();
	}
	
	
	/*---------------------------------------   Password Encoder  -------------------------------------------*/	

	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }
}
