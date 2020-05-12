package com.paolomanlunas.photoappapiusers.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

   private Environment environment; // we use this to get 'gateway.ip' from application.properties

   @Autowired
   public WebSecurity(Environment environment) {
      this.environment = environment;
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable();
      http
              .authorizeRequests()
              .antMatchers("/**")
              .hasIpAddress(environment.getProperty("gateway.ip"));

      // Whiteframe - Disable to avoid whiteframe when connecting to h2-console
      http.headers().frameOptions().disable();
   }
}
