package com.example.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/members/register").permitAll() // 회원가입 경로 허용
                        .anyRequest().authenticated() // 나머지 요청들은 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/login") // 커스텀 로그인 페이지 경로 설정
                        .defaultSuccessUrl("/", true) // 로그인 성공시 리디렉션 경로 설정
                        .permitAll() // 모든 사용자가 로그인 페이지 접근 허용
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login") // 로그아웃 성공시 리디렉션 경로 설정
                        .permitAll() // 로그아웃 경로 허용
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/members/*"));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCryptPasswordEncoder를 사용하여 비밀번호를 암호화합니다.
    }
}
