package com.stlh.doctorbackend.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.stlh.doctorbackend.jwt.JwtFilter;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class DoctorSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	DoctorlogdService doctorlogdService;
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Bean
	public AuthenticationProvider authprovider() {
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setUserDetailsService(doctorlogdService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
				
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub,"/update/{did}"
		http.csrf().disable().authorizeRequests().
		antMatchers("/api/doctors/add","/api/doctors/authenticate","/api/doctors/alldoctors","/api/doctors/get/{email}").permitAll().antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest()
		.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	
	
}
