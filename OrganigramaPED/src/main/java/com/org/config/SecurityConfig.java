package com.org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager userDetailsService= new InMemoryUserDetailsManager();
		UserDetails user= User.withUsername("admin").password(passwordEncoder().encode("admin")).authorities("read").build();
		userDetailsService.createUser(user);
		return userDetailsService;
	}
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.formLogin();
		http.csrf().ignoringRequestMatchers("/fetch-data/**", "/transaction/**"); // Ignorar CSRF para estas rutas
		http.authorizeHttpRequests().anyRequest().authenticated();
		return http.build();
	}
	
	
}