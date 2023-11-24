package com.shop.miniShoppingMall.controller;

import com.shop.miniShoppingMall.model.MemberEntity;
import com.shop.miniShoppingMall.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/loginUI")
    public String loginUI() {
        return "member/loginForm";
    }

    @RequestMapping("/joinUI")
    public String joinUI() {
        return "member/joinForm";
    }

    @RequestMapping("/successJoin")
    public String welcome() { return "member/successJoin"; }

    @PostMapping("/member")
    public String createMember(@RequestBody MemberEntity request) {
        MemberEntity member =  memberService.createMember(request);
        return "member/successJoin";
    }

    @PutMapping("/member/{userid}")
    @ResponseBody
    public void editMember(@PathVariable String userid, @RequestBody MemberEntity request) {
        memberService.editMember(userid, request);
    }

    @DeleteMapping("/member/{userid}")
    @ResponseBody
    public void deleteMember(@PathVariable String userid) {
        memberService.deleteMember(userid);
    }

    @GetMapping("/memberIdCheck")
    @ResponseBody
    public String memberIdCheck(@RequestParam String userid){
        boolean check = memberService.memberIdCheck(userid);

        if(check) {
            return "사용 가능한 아이디입니다.";
        } else {
            return "이미 사용 중인 아이디입니다.";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody MemberEntity member, HttpSession session) {
        boolean check = memberService.login(member.getUserid(), member.getPasswd());

        if(check) {
            session.setAttribute("login", member.getUserid());
            return "로그인을 성공하셨습니다";
        } else {
            return "로그인에 실패하셨습니다";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "member/successLogout";
    }

}
