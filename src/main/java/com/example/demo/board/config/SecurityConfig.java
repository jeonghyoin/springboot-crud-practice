package com.example.demo.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.board.service.CustomUserDetailsService;
import com.example.demo.security.util.CustomAuthProvider;
 
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired CustomUserDetailsService customUserDetailsService;
    @Autowired public CustomAuthenticationFailHandler customAuthenticationFailHandler;
    @Autowired public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired private CustomAuthProvider customAuthProvider;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf().disable()
        .authorizeRequests()
        	//.antMatchers("/login", "/join", "/joinForm", "/join/authAdmin", "/resources/**").permitAll()
        	//.antMatchers("**").authenticated()
        	.antMatchers("/admin/**").hasRole("ADMIN") //관리자만 들어갈 수 있게 만들기
        	.and()
            .exceptionHandling().accessDeniedPage("/access")
        .and()
        .formLogin()
            //로그인 폼 표시 경로
            .loginPage("/login").permitAll() //커스터마이징
        	.usernameParameter("username")
        	.passwordParameter("password")
        	.successForwardUrl("/list")
        	.failureHandler(customAuthenticationFailHandler)
        	//.successHandler(customAuthenticationSuccessHandler)
        .and()
        .logout()
	        .logoutSuccessUrl("/login") //로그아웃이 처리됐을 때 넘어갈 곳 설정
        .and()
        .sessionManagement()
    		.maximumSessions(1) //세션 최대 갯수 제한
    		.maxSessionsPreventsLogin(false); //기존 접속자의 session을 종료
    }
    
	/* 비밀번호 암호화 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        //auth.authenticationProvider(customAuthProvider);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
