package com.api.backpackerapi;

import static org.assertj.core.api.Assertions.assertThat;

import com.api.backpackerapi.domain.Member;
import com.api.backpackerapi.domain.OrderDt;
import com.api.backpackerapi.repository.MemberRepository;
import com.api.backpackerapi.repository.OrderDtRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderDtRepository orderRepository;

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    public void 데이타세팅(){
        System.out.println("[init Setting]");
        List<Member> memberList = new ArrayList<>();
        //멤버 저장

        memberList.add(Member.builder()
                        .name ("chris")
                        .nickName("cha-cha")
                        .passwords( "1234")
                        .phone("91724246767")
                        .email("test1@gmail.com")
                        .gender("M")
                        .build());
        memberList.add(Member.builder()
                .name ("kate")
                .nickName("chi-ske")
                .passwords( "1234")
                .phone("123456789")
                .email("test2@gmail.com")
                .gender("F")
                .build());
        memberList.add(Member.builder()
                .name ("terry")
                .nickName("amoa")
                .passwords( "1234")
                .phone("234567890")
                .email("test3@gmail.com")
                .gender("F")
                .build());
        memberList.add(Member.builder()
                .name ("alice")
                .nickName("peepee")
                .passwords( "1234")
                .phone("345678912")
                .email("test4@gmail.com")
                .gender("F")
                .build());

        memberList = memberRepository.saveAll(memberList);

        List<OrderDt> orderList = new ArrayList();

        orderList.add(OrderDt.builder()
                .itemName("티셔츠")
                .orderNumber("202206211823")
                .paymentDateTime(LocalDateTime.now())
                .memberId(1)
                .build());
        orderList.add(OrderDt.builder()
                .itemName("티셔츠2")
                .orderNumber("202206181113")
                .paymentDateTime(LocalDateTime.of(2022,06,18,11,13,10))
                .memberId(1)
                .build());
        orderList = orderRepository.saveAll(orderList);
        clear();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<init Setting>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

    @Test
    void 회원가입() {
        //멤버 저장
        Member member = new Member("chris2", "cha-cha", "1234", "91724246767", "test97@gmail.com", "F");
        Member result = memberRepository.save(member);

        Member findMember = memberRepository.findById(result.getId()).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    /**
     * 회원 로그인(인증) - JWT 이용
     */
    @Test
    void 회원_로그인_인증(){
        // 회원조회 - 이름, 전화번호
        Member member = new Member();
//        Assertions.assertThat(member, member);
    }

    /**
     * 회원 로그아웃
     * - 로그아웃 시간 update
     */
    @Test
    void 회원_로그아웃(){
        long id = 1;
        // 회원 id 로그아웃 - 시간 업데이트
        Member member = memberRepository.findById(id).get();
        member.updateLogoutTime();
        System.out.println(member.toString());
        Member result = memberRepository.save(member);
        System.out.println(result.toString());
    }

    /**
     * 단일 회원 상세 정보 조회
     * - 고객명, 핸드폰번호 기준으로 조회
     */
    @Test
    void 회원_조회_이메일(){
        // 이메일로 조회
        String email = "test1@gmail.com";
        List<Member> memberList = memberRepository.findByEmail(email);
        assertThat(memberList.size()).isEqualTo(1);
    }

    @Test
    void 회원_조회_아이디(){
        long id = 1;
        Member member = memberRepository.findById(id).get();
        assertThat(member.getId()).isEqualTo(1);
    }
    /**
     * 여러 회원 조회, pagenation으로 단위 조절하여 조회
     * - 조회 조건 이름, 이메일
     * - 포함 내역 마지막 주문 정보
     */
    @Test
    void 회원_다중_조회(){
        // 이름 or 이메일
        String email = "test1";
        List<Member> memberList = memberRepository.findByEmailContaining(email);
        // 노출 내역 회원정보 상세 + 최근 구매이력
        assertThat(memberList.size()).isEqualTo(1);
    }

    @Test
    void 주문조회_회원_마지막주문정보(){
        List<Member> orderDtList = memberRepository.findAllWithOrderDetail();
        assertThat(orderDtList.size()).isEqualTo(5);
    }
    @AfterEach
    void clear() {
//        em.flush();
        em.clear();
    }
}
