
package com.example.BookStoreMgmt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
				.anyRequest().authenticated())
// .formLogin(form -> form
// .loginPage("/login")
// .permitAll()
// )
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/", true) // Redirect to home page on
																							// successful login
						.failureUrl("/login?error") // Explicitly set the failure URL
						.permitAll())
				.logout(logout -> logout.permitAll());
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("admin").password("admin123").roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}