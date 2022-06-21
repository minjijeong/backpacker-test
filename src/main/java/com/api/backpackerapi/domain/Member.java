package com.api.backpackerapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    // PK 지정
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO) // 데이터베이스에 따라 자동으로 ID가 지정
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String email;

    private String passwords;

    @Column(length = 12, nullable = false)
    private String phone;

    @Column(length = 1)
    private String gender;

    @JsonIgnore
    private LocalDateTime logoutDtime;

    @JsonIgnore
    private LocalDateTime lastOrderDtime;
//
//    @OneToMany
//    private List<Order> orders;
    @Builder
    public Member(String name, String nickName, String passwords, String phone, String email, String gender){
        this.name = name;
        this.nickName = nickName;
        this.passwords = passwords;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public void updateLogoutTime(){
        this.logoutDtime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", passwords='" + passwords + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", logoutDtime='" + logoutDtime + '\'' +
                ", lastOrderDtime='" + lastOrderDtime + '\'' +
                '}';
    }
}
