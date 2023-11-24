package com.shop.miniShoppingMall.service;

import com.shop.miniShoppingMall.model.MemberEntity;
import com.shop.miniShoppingMall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
   private final MemberRepository memberRepository;
    public MemberEntity createMember(MemberEntity request) {
        memberRepository.save(request);
        return request;
    }

    public void editMember(String userid, MemberEntity request) {
        MemberEntity member = memberRepository.findById(userid).orElseThrow();
        member.changeMember(request.getUsername(), request.getPost(), request.getAddr1(), request.getAddr2(), request.getPhone(), request.getEmail());
        memberRepository.save(member);
    }

    public void deleteMember(String userid) {
        MemberEntity member = memberRepository.findById(userid).orElseThrow();
        memberRepository.delete(member);
    }

    public boolean memberIdCheck(String userid) {
        Optional<MemberEntity> member = memberRepository.findById(userid);

        return member.isEmpty();
    }

    public boolean login(String userid, String passwd) {
        MemberEntity member = memberRepository.findById(userid).orElseThrow();

        if(member.getPasswd().equals(passwd)) {
            return true;
        } else {
            return false;
        }
    }
}
