package com.api.backpackerapi;

import static org.assertj.core.api.Assertions.assertThat;

import com.api.backpackerapi.domain.Member;
import com.api.backpackerapi.domain.OrderDt;
import com.api.backpackerapi.repository.OrderDtRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderDtRepositoryTests {
    @Autowired
    private OrderDtRepository orderRepository;

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    public void 데이타세팅(){
        System.out.println("[init Setting]");
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
        orderList.add(OrderDt.builder()
                .itemName("바지1")
                .orderNumber("202206151823")
                .paymentDateTime(LocalDateTime.of(2022,06,15,18,23,10))
                .memberId(1)
                .build());
        orderList.add(OrderDt.builder()
                .itemName("바지12")
                .orderNumber("202206151823")
                .paymentDateTime(LocalDateTime.of(2022,06,15,18,23,10))
                .memberId(2)
                .build());
        orderList.add(OrderDt.builder()
                .itemName("바지13")
                .orderNumber("202206151823")
                .paymentDateTime(LocalDateTime.of(2022,06,15,18,23,10))
                .memberId(3)
                .build());
        orderList = orderRepository.saveAll(orderList);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<init Setting>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
    @Test
    void 주문조회_단일회원(){
        long id = 1;
        List<OrderDt> orderDtList = orderRepository.findAllByMemberId(id);
        assertThat(orderDtList.size()).isEqualTo(3);
    }

    @Test
    void 주문조회_상품이름(){
        String itemName = "바지12";
        List<OrderDt> orderDtList = orderRepository.findAllByItemName(itemName);
        assertThat(orderDtList.size()).isEqualTo(1);
    }

    @Test
    void 주문조회_이메일(){
        String email = "@gmail.com";
        List<OrderDt> orderDtList = orderRepository.findAllByEmail(email);
        assertThat(orderDtList.size()).isEqualTo(5);
    }
}
