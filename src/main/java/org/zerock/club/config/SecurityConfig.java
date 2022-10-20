package org.zerock.club.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter { //시큐리티 관련 기능을 쉽게 설정 가능

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    } //패스워드를 암호화 처리하기 위한 객체를 생성

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                //로그인 하지 않은 사용자가 접속 가능한 URL
                .antMatchers("/sample/member").hasRole("USER");
                //로그인 한 사용자만 접속 가능한 URL

        http.formLogin(); //인증, 인가 문제 발생시 오류화면 대신 로그인 화면으로 출력
        http.csrf().disable(); //해킹에 대한 공격을 막는 메서드
        http.logout(); //로그아웃 페이지 생성
    }

/*    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((auth) -> {
            auth.antMatchers("/sample/all").permitAll();
            auth.antMatchers("/sample/member").hasRole("USER");
        });

        http.formLogin();
        http.csrf().disable();
        http.logout();


        return http.build();
    }*/

/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //사용자 계정은 user1
        auth.inMemoryAuthentication().withUser("user100@zerock.org")
                //tests에 있는 암호화 된 패스워드
                .password("$2a$10$5aslLjvuXw7gnntYAmV/Ju1rscSvoXrtr9yRrCT5AbprDmGBCwYVy")
                .roles("USER");
    }*/
}
