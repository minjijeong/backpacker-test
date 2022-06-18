package com.api.backpackerapi;

import com.api.backpackerapi.domain.Member;
import com.api.backpackerapi.service.ApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "ApiController", tags = "사용자 등록/조회 API")
public class ApiController {

    private ApiService service;

    @Autowired
    public ApiController(ApiService service){
        this.service = service;
    }


    @GetMapping("/hello")
    public void sayHello(){
        System.out.println("sayHello");
    }

    @PostMapping("/join")
    @ApiOperation(value="hello, World API", notes="hello, World를 반환하는 API, Ajax 통신 확인용.")
    public String join(Member member){
        System.out.println(member);
        // 유효하지 않은 데이타

        // 이미 가입된 고객

        // 정상 가입
        Member result = service.save(member);
        return  String.valueOf(result.getId());
    }
}
