package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	//Create rules that require authentication for all endpoints except /registration
	
	@Override
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
		  httpSecurity.authorizeRequests()
		  				.antMatchers("/admin").hasRole("ADMIN")
		  				//.antMatchers("/user").hasAnyRole("USER", "ADMIN")
		  				//.antMatchers("/").permitAll()
		  				.and().formLogin();
 
		  }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("simpleUser")
//				.password("password")
//				.roles("USER")
//				.and()
//				.withUser("admin")
//				.password("admin")
//				.roles("ADMIN");
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select nom,password,enabled " +
						"from client " +
						"where nom = ? ")
				.authoritiesByUsernameQuery("select nom,role " +
						"from client " +
						"where nom = ? ");
	}


	 //Crypting password
	 @Bean
	  public PasswordEncoder passwordEncoder() {
	    //return new BCryptPasswordEncoder();
		 return NoOpPasswordEncoder.getInstance();
	  }
	  
	 
}
