package com.api.backpackerapi;

import com.api.backpackerapi.domain.Member;
import com.api.backpackerapi.repository.MemberRepository;
import com.api.backpackerapi.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackpackerApiApplicationTests {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public BackpackerApiApplicationTests(MemberRepository memberRepository, OrderRepository orderRepository){
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
    }


    @Test
    void 회원가입() {
        //멤버 저장
        Member member = new Member();
        member.setName("chris");
        member.setNickName("cha-cha");
        member.setPasswords("1234");
        member.setPhone("9172426767");
        member.setEmail("test@gmail.com");
//        member.setGender("F");

        memberRepository.save(member);
//
        Member findMember = memberRepository.findById(member.getId()).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

}
