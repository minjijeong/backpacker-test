package com.api.backpackerapi.repository;

import com.api.backpackerapi.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);

    @Query("select c from Member c where c.email = :email and c.name = :name")
    Member findByNameAndEmail(String name, String email);
    List<Member> findByEmail(String email);

    @Query("Select c from Member c where c.email like %:email%")
    List<Member> findByEmailContaining(@Param("email")String email);

    @Query("Select new com.api.backpackerapi.dto.member.MemberWithOrderDto(m.id, m.name, m.email, m.phone, m.nickName, m.passwords, m.logoutDtime, max(c.paymentDateTime) as lastOrderDtime)"
            +"from Member m left join OrderDt c on m.id = c.memberId "
            +"where 1=1 "
            +"group by m.id, m.name, m.email, m.phone, m.nickName, m.passwords, m.logoutDtime")
    List<Object> findAllWithOrderDetail();

    List<Member> findAll();
    Member save(Member member);
}
