package com.ucb.Nexo_Backend;

import com.ucb.Nexo_Backend.util.AuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class NexoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexoBackendApplication.class, args);
	}
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable()
					.addFilterAfter(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/world").permitAll()
					.antMatchers(HttpMethod.GET, "/country/**").permitAll()
					.antMatchers(HttpMethod.GET, "/world_cases").permitAll()
					.antMatchers(HttpMethod.GET, "/bol").permitAll()
					.antMatchers(HttpMethod.GET, "/department/**").permitAll()
					.antMatchers(HttpMethod.GET, "/bol_cases").permitAll()
					.antMatchers(HttpMethod.GET, "/municipio/**").permitAll()
					.antMatchers(HttpMethod.GET, "/municipios/**").permitAll()
					.antMatchers(HttpMethod.POST, "/administrator/login").permitAll()
					.anyRequest().authenticated();
		}
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins(Arrays.asList("*"));
			configuration.addAllowedHeader("*");
			configuration.addAllowedMethod("*");
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}
	}
}
