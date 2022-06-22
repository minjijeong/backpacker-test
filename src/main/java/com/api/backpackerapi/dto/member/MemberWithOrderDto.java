package com.api.backpackerapi.dto.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberWithOrderDto {
    private Long id;
    private String name;
    private String nickName;
    private String email;
    private String passwords;
    private String phone;
    private String gender;
    private LocalDateTime logoutDtime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime lastOrderDtime;
}
