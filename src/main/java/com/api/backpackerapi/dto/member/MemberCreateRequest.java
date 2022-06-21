package com.api.backpackerapi.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "신규 회원 가입 요청")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberCreateRequest {
    @ApiModelProperty(value = "회원 이름", notes = "회원 이름을 입력해주세요", required = true, example = "임test")
    @NotBlank(message = "{memberCreateRequest.name.notBlank}")
    @Size(min = 2, max = 30, message = "{memberCreateRequest.name.size}")
    private String name;

    @ApiModelProperty(value = "별명", notes = "별명을 입력해주세요", required = true, example = "김수한무")
    @NotBlank(message = "{memberCreateRequest.nickName.notBlank}")
    @Size(min = 2, max = 30, message = "{memberCreateRequest.nickName.size}")
    private String nickName;

    @ApiModelProperty(value = "비밀번호", notes = "비밀번호를 입력해주세요", required = true, example = "test1234912!")
    @NotBlank(message = "{memberCreateRequest.password.notBlank}")
    @Size(min = 2, max = 30, message = "{memberCreateRequest.password.size}")
    private String password;

    @ApiModelProperty(value = "전화번호", notes = "전화번호를 입력해주세요", required = true, example = "01012341234!")
    @NotBlank(message = "{memberCreateRequest.phone.notBlank}")
    @Size(min = 2, max = 30, message = "{memberCreateRequest.phone.size}")
    private String phone;

    @ApiModelProperty(value = "이메일", notes = "이메일을 입력해주세요", required = true, example = "test@gmail.com")
    @NotBlank(message = "{memberCreateRequest.email.notBlank}")
    @Size(min = 2, max = 30, message = "{memberCreateRequest.email.size}")
    private String email;

    @ApiModelProperty(value = "성별", notes = "성별을 입력해주세요. (M: 남성, F: 여성, 그외: X", example = "F")
    private String gender;
}
