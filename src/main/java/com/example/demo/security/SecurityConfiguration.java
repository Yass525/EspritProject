package com.example.demo.security;

import com.example.demo.filters.JwtRequestFilter;
import com.example.demo.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.KeyGenerator;
import javax.sql.DataSource;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	JwtRequestFilter jwtRequestFilter;

	//Create rules that require authentication for all endpoints except /registration
	@Override
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
		 //httpSecurity.csrf().disable();
		;
		  httpSecurity.csrf().disable().cors().disable()
				  .authorizeRequests()
				  .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
				  .antMatchers("/user","/user/**").hasAnyRole("USER", "ADMIN")
				  .antMatchers("/authenticate","/**").permitAll()
				  .anyRequest().authenticated()
				  //.antMatchers("/**").permitAll()
				  //.and().formLogin();
				  .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		  httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//Using JWT
		auth.userDetailsService(myUserDetailsService)
				.passwordEncoder(passwordEncoder());

		//using JDBC
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.passwordEncoder(passwordEncoder())
//				.usersByUsernameQuery("select nom,password,enabled " +
//						"from client " +
//						"where nom = ? ")
//				.authoritiesByUsernameQuery("select nom,role " +
//						"from client " +
//						"where nom = ? ");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	 //Crypting password
	 @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
		// return NoOpPasswordEncoder.getInstance();
	  }
	  
	 
}
