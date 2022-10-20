package org.zerock.club.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("패스워드 암호화 일치 여부 테스트")
    public void testEncode(){

        String password = "1111";

        String enPw = passwordEncoder.encode(password);

        System.out.println("enPw : " + enPw);

        boolean matchResult = passwordEncoder.matches(password, enPw);

        System.out.println("matchResult : " + matchResult);
        //암호화 된 패스워드와 그냥 패스워드와 일치 여부 확인
    }// test1
    //enPw : $2a$10$2WrTbC7bn0eA9uk.jEEcW.8TvBCKNM/Vo5DjEgCAq./VfKKf1yhFy
    //matchResult : true
    //test2
    //enPw : $2a$10$qd7JnaPs5wcF4Jr2TrIP8OQM3l0ftK4uT12z47.GdVwtk2Q9njjui
    //matchResult : true
}
