package com.api.backpackerapi.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회원 정보 조회")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSelectRequest {
    @ApiModelProperty(value = "회원 이름", notes = "회원 이름을 입력해주세요", required = true, example = "test")
    private String name;

    @ApiModelProperty(value = "e-mail", notes = "이메일을 입력해주세요", required = true, example = "test@gmail.com")
    private String email;
}