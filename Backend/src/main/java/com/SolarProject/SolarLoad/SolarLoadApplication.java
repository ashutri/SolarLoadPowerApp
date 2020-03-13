package com.SolarProject.SolarLoad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(scanBasePackages="com.SolarProject")
@EnableWebSecurity
public class SolarLoadApplication {

	protected void configure(HttpSecurity http) throws Exception {
        http.csrf().
        disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
	public static void main(String[] args) {
		SpringApplication.run(SolarLoadApplication.class, args);
	}

}
