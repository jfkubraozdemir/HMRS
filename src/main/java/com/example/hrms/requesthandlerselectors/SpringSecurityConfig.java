package com.example.hrms.requesthandlerselectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.hrms.security.CustomUserDetailsService;
import com.example.hrms.security.JwtFilter;





@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
       private JwtFilter jwtFilter;
   
    @Autowired
       private CustomUserDetailsService userDetailsService;

       @Override
       protected void configure(AuthenticationManagerBuilder auth) throws Exception {
           auth.userDetailsService(userDetailsService);
       }

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http.csrf().disable()
                   .authorizeRequests().antMatchers("/login").permitAll().and()
               .authorizeRequests().antMatchers(
                     "/v2/api-docs",
                     "/swagger-resources/**",
                     "/swagger-ui.html",
                     "/webjars/**" ,
                     "/swagger.json")
               .permitAll()
          .antMatchers("/*").denyAll()
                   .anyRequest().authenticated()
                   .and().sessionManagement()
                   .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // ***
           http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
       }

       public JwtFilter getJwtFilter() {
         return jwtFilter;
      }
      public void setJwtFilter(JwtFilter jwtFilter) {
         this.jwtFilter = jwtFilter;
      }
      public CustomUserDetailsService getUserDetailsService() {
         return userDetailsService;
      }
      public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
         this.userDetailsService = userDetailsService;
      }
      public static String[] getAuthWhiteList() {
         return AUTH_WHITE_LIST;
      }
      @Bean
       public PasswordEncoder passwordEncoder() {
           return NoOpPasswordEncoder.getInstance();
       }
       @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
       @Override
       public AuthenticationManager authenticationManagerBean() throws Exception {
           return super.authenticationManagerBean();
       }
       private static final String[] AUTH_WHITE_LIST = {
               "/v3/api-docs/**",
               "/swagger-ui/**",
               "/v2/api-docs/**",
               "/swagger-resources/**"
       };
       @Override
      public void configure(WebSecurity web) throws Exception {
         web.ignoring()
               .antMatchers("/javax.faces.resource/**", "/download", "/GenericErrorHandler", "/v2/**",
                     "/systemimage", "/public/**", "/login.xhtml", "/resources/**", "**/temp/**", "/swagger**",
                     "/swagger-ui.html/**")
               .antMatchers(HttpMethod.OPTIONS, "/**");
      }
}