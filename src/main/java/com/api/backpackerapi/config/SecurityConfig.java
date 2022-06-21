package com.api.backpackerapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        String password = "1234";

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println("PASSWORD>>>>>>>>>>>");
        System.out.println(encoder.encode("password"));

        UserDetails user = User.withUsername("user")
                .password(encoder.encode(password))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // 스프링 시큐리티로 인해 POST 403 에러로 떨어져서 처리
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/v2/api-docs",  "/configuration/ui",
                        "/swagger-resources", "/configuration/security",
                        "/swagger-ui.html", "/webjars/**","/swagger/**").permitAll()
                .anyRequest().authenticated()
                .and()
//                .csrf()
//                .ignoringAntMatchers("/h2-console/**")
//                .ignoringAntMatchers("/v2/api-docs",  "/configuration/ui",
//                        "/swagger-resources", "/configuration/security",
//                        "/swagger-ui.html", "/webjars/**","/swagger/**")
//                .and()
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and();

    }
}
