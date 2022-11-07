package com.cognixia.jump.tcg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cognixia.jump.tcg.filter.JwtRequestFilter;

@Configuration
public class SecurityConfiguration 
{
	//when you perform dependency injection, check if any of files in this app are UserDetailServiceFilkes
	//if so, create an object of that class for this variable
	@Autowired
	UserDetailsService uds;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	//Authenticatioon
	@Bean
	protected UserDetailsService userDetailsService() //uds = UserDetailService
	{
		return uds;
	}
	
	
	//Authorization
	@Bean
	protected SecurityFilterChain filterChain( HttpSecurity http) throws Exception
	{
		http.csrf().disable()
				   .authorizeRequests()
				   .antMatchers(HttpMethod.GET, "/api/hello").permitAll()
				   .antMatchers("/api/users/*").permitAll()//allows all users including non logged in users to access this uri
				   .antMatchers("/api/admin/*").hasRole("ADMIN")
				   .antMatchers(HttpMethod.POST,"/api/admin/vanguard/add").hasRole("ADMIN")
				   .antMatchers(HttpMethod.GET, "/api/testing").permitAll()
				   .antMatchers("/api/authenticate").permitAll()
				   .antMatchers(HttpMethod.GET, "/v3/api-docs/").permitAll()
				   .anyRequest().authenticated()  //this chunck makes it so some login is needed to access any APIS
				   .and()
				   .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ); // tell spring security to NOT create sessions
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean
	protected PasswordEncoder encoder()
	{
		//return NoOpPasswordEncoder.getInstance(); //just a temp solution for now that provides a plain text (unecrpted password) for learning purposes
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); 
		
		authProvider.setUserDetailsService(uds);
		authProvider.setPasswordEncoder( encoder() );
		
		return authProvider;
	}
	
	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
}
