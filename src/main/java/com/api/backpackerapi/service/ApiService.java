package com.api.backpackerapi.service;

import com.api.backpackerapi.domain.Member;
import com.api.backpackerapi.dto.member.MemberCreateRequest;
import com.api.backpackerapi.repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
    private MemberRepository memberRepository;

    @Autowired
    public ApiService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * - 고객 정보 insert
     */
    // 정상 가입
    public Member save(MemberCreateRequest request){
        // 유효하지 않은 데이타 체크


        // 이미 가입된 고객

        // Dto 변환
        Member member = Member.builder()
                .email(request.getEmail())
                .name(request.getName())
                .gender(request.getGender())
                .nickName(request.getNickName())
                .passwords(request.getPassword())
                .phone(request.getPhone())
                .build();

        Member result = memberRepository.save(member);
        return result;
    }


    /**
     * 회원 로그인(인증) - JWT 이용
     */

    /**
     * 회원 로그아웃
     * - 로그아웃 시간 update
     */


    /**
     * 단일 회원 상세 정보 조회
     * - 고객명, 핸드폰번호 기준으로 조회
     */

    public Member getMember(String name, String email) {
        Member member = memberRepository.findByNameAndEmail(name, email);
        return member;
    }
    /**
     * 단일 회원 주문 목록 조회
     * - 고객ID 기준으로 조회
     */
    public Member getMemberById(long id) {
        return memberRepository.findById(id).get();
    }

    /**
     * 여러 회원 조회, pagenation으로 단위 조절하여 조회
     * - 조회 조건 이름, 이메일
     * - 포함 내역 마지막 주문 정보
     */

    /**
     * 모든 회원 조회
     */
    public List<Member> getAllMembers() {
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }


}
