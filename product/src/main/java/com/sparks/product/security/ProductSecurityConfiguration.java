package com.sparks.product.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProductSecurityConfiguration {

	@Bean
	SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(request ->
			request.requestMatchers("/api/products/**").authenticated().requestMatchers("/api/sales/**").authenticated().requestMatchers("/login").permitAll()).httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());
		return http.build();
	}
}
