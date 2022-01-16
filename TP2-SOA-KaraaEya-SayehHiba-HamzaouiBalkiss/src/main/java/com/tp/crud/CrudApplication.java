package com.tp.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Configuration
	public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/**");
		}
	}

}
