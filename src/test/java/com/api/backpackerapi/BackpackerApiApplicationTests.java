package com.api.backpackerapi;

import com.api.backpackerapi.entity.Member;
import com.api.backpackerapi.entity.OrderDt;
import com.api.backpackerapi.repository.MemberRepository;
import com.api.backpackerapi.repository.OrderDtRepository;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackpackerApiApplicationTests {

    private final MemberRepository memberRepository;
    private final OrderDtRepository orderDtRepository;

    @Autowired
    public BackpackerApiApplicationTests(MemberRepository memberRepository, OrderDtRepository orderDtRepository){
        this.memberRepository = memberRepository;
        this.orderDtRepository = orderDtRepository;
    }

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    public void 데이타세팅(){
        System.out.println("[init Setting]");
        //멤버 저장
        Member member = new Member("chris", "cha-cha", "1234", "91724246767", "test98@gmail.com", "F");
        Member result = memberRepository.save(member);
        System.out.println(result.getId());
        System.out.println(result.toString());

        // 주문 저장
        OrderDt orderDt = new OrderDt("202206200000", "스카치블루", result.getId(), LocalDateTime.now());
        orderDt = orderDtRepository.save(orderDt);
        System.out.println(orderDt.toString());

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<init Setting>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

    @Test
    void 회원가입() {
        //멤버 저장
        Member member = new Member("chris1111", "cha-cha", "1234", "91724246767", "test99@gmail.com", "F");
        Member result = memberRepository.save(member);
//
        Member findMember = memberRepository.findById(result.getId()).get();
        System.out.println(">>>>>>>>>> "+findMember.toString());
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
        // 회원 id 로그아웃 - 시간 업데이트
    }

    /**
     * 단일 회원 상세 정보 조회
     * - 고객명, 핸드폰번호 기준으로 조회
     */
    @Test
    void 회원_조회(){
        // 이메일로 조회
    }

    /**
     * 단일 회원 주문 목록 조회
     * - 고객ID 기준으로 조회
     */
    @Test
    void 회원_주문_조회(){
        // 고객 id 기준 주문 상세 조회
    }

    /**
     * 여러 회원 조회, pagenation으로 단위 조절하여 조회
     * - 조회 조건 이름, 이메일
     * - 포함 내역 마지막 주문 정보
     */
    @Test
    void 회원_다중_조회(){
        // 이름 or 이메일
        // 노출 내역 회원정보 상세 + 최근 구매이력
    }

    @AfterEach
    void clear() {
//        em.flush();
        em.clear();
    }

}
