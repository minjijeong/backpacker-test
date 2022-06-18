package com.api.backpackerapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiImplicitParam;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import springfox.documentation.annotations.ApiIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    // PK 지정
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO) // 데이터베이스에 따라 자동으로 ID가 지정
    public long id;

    @Column(length = 100, nullable = false)
    public String name;

    @Column(length = 100, nullable = false)
    public String nickName;

    @Column(nullable = false)
    public String passwords;

    @Column(length = 12, nullable = false)
    public String phone;

    @Column(nullable = false)
    public String email;

    @Column(length = 1)
    public String gender;

}
