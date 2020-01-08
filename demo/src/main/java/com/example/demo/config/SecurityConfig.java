package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//authorizeRequests() : 요청에 권한 부여
		http.authorizeRequests()
		
		//antMatchers() : URL별 접근 권한 체크
		//hasRole(role) : role 권한을 가진 요청만 허용
		//permitAll() : 모든 접근 허용
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/myinfo").hasRole("MEMBER")
		//.antMatchers("/**").permitAll()
		
		//anyRequest() : 모든 요청
		//authenticated() : 인증된 사용자만
		.anyRequest().authenticated()
		
		.and()
		// 로그인 설정
		.formLogin()
		//loginPage()을 지정 안하면 Spring Security 기본 로그인 FORM 사용
		.loginPage("/user/login")
		.defaultSuccessUrl("/user/login/result")
		.permitAll()
		
		.and() 
		
		// 로그아웃 설정
		.logout()
		//.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
		.logoutSuccessUrl("/user/logout/result")
		//세션 초기화
		.invalidateHttpSession(true)
		.and()
		// 403 예외처리 핸들링
		.exceptionHandling().accessDeniedPage("/user/denied");
	}
}
