package com.used.example.config;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.used.example.service.UserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled= true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	@Bean
	public  AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}// 암호화된 패스워드를 계속 저장
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}//이래야 밖(config밖)에서 사용가능함
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable()
		          .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		          .authorizeRequests().antMatchers("/api/auth/**").permitAll()
		          .antMatchers("/api/test/**").permitAll()
		          .antMatchers("/api/user/**").permitAll()
		          .antMatchers("/api/offer/**").permitAll()
		          .antMatchers("/api/image/**").permitAll()
		          .antMatchers("/api/auction/**").permitAll()
		          .antMatchers("/api/like/**").permitAll()
		          .antMatchers("/api/payment/**").permitAll()
		          .anyRequest().authenticated();
		          
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);          
		  
		          
		          
		          
		
		
		
	}
	

}
