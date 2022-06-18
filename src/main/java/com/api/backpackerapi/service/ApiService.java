package com.api.backpackerapi.service;

import com.api.backpackerapi.domain.Member;
import com.api.backpackerapi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
    private MemberRepository memberRepository;

    @Autowired
    public ApiService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Member save(Member member){
        Member result = memberRepository.save(member);
        return result;
    }
}
