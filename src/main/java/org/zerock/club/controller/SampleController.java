package org.zerock.club.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.club.security.dto.ClubAuthMemberDTO;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {
    
    @GetMapping("/all") //모든 사용자가 접속 가능
    public void exAll(){
        log.info("exAll.......모든 사용자 접속");
    } //sample/all -> 로그인을 하지 않아도 접속 가능

    @GetMapping("/member") //모든 회원 접속 가능
    public void exMember(@AuthenticationPrincipal ClubAuthMemberDTO clubAuthMember){
        log.info("exMember.......회원 접속");

        log.info("---------------------------");
        log.info(clubAuthMember);
    } //sample/member -> 로그인 회원만 접속 가능

    @GetMapping("/admin") //관리자만 접속 가능
    public void exAdmin(){
        log.info("exAdmin.......관리자 접속");
    } //sample/admin -> 관리자만 접속 가능
}
