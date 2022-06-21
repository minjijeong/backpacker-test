package com.api.backpackerapi.repository;

import com.api.backpackerapi.domain.Member;
import com.api.backpackerapi.domain.OrderDt;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDtRepository extends JpaRepository<OrderDt, Long> {
    OrderDt save(OrderDt orderDt);
    List<OrderDt> findAll();
    List<OrderDt> findAllById(Long id);

    @Query("Select c from OrderDt c where c.memberId = :memberId")
    List<OrderDt> findAllByMemberId(long memberId);

    @Query("Select c from OrderDt c where c.itemName like %:itemName%")
    List<OrderDt> findAllByItemName(String itemName);

    @Query("Select c from OrderDt c, Member m where m.id = c.memberId and m.email like %:email%")
    List<OrderDt> findAllByEmail(String email);

}