package com.api.backpackerapi.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    // PK 지정
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO) // 데이터베이스에 따라 자동으로 ID가 지정
    private long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String passwords;

    @Column(length = 12, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(length = 1)
    private String gender;

    @OneToMany
    private List<Order> orders;
}
