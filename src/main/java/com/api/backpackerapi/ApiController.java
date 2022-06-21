package com.api.backpackerapi;

import com.api.backpackerapi.domain.Member;
import com.api.backpackerapi.dto.member.MemberCreateRequest;
import com.api.backpackerapi.dto.member.MemberSelectRequest;
import com.api.backpackerapi.dto.response.Response;
import com.api.backpackerapi.service.ApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@Api(value = "ApiController", tags = "사용자 등록/조회 API")
public class ApiController {

    private ApiService service;

    @Autowired
    public ApiController(ApiService service){
        this.service = service;
    }


    @ApiOperation(value ="커넥션 테스트", notes = "hello, world 정상 출력 확인" )
    @GetMapping("/hello")
    public Response sayHello(){
        return Response.success("hello, world");
    }

    /**
     * 회원가입
     * - 고객 정보 insert
     * @param request
     * @return
     */
    @ApiOperation(value="신규 회원 가입", notes="신규 회원 정보를 입력하여 전송", response = MemberCreateRequest.class)
    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    public Response join(@Valid @RequestBody MemberCreateRequest request){
        System.out.println(request);
        // 유효하지 않은 데이타
        // 이미 가입된 고객
        // 정상 가입
        Member result = service.save(request);
        return  Response.success();
    }

    /**
     * 회원 로그인(인증) - JWT 이용
     */

    /**
     * 회원 로그아웃
     * - 로그아웃 시간 update
     */

    /**
     * 단일 회원 상제 정보 조회
     * - 고객명, 핸드폰번호 기준으로 조회
     */

    @ApiOperation(value = "회원 정보 조회", notes = "회원 정보를 조회한다.")
    @GetMapping("/member")
    @ResponseStatus(HttpStatus.OK)
    public Response getMemberByParam(@ApiParam(value="회원 이름", required = true, example = "test") @RequestParam String name,
                                    @ApiParam(value="이메일", required = true, example = "test@gmail.com") @RequestParam String email) {
        return Response.success(service.getMember(name, email));
    }

    /**
     * 단일 회원 주문 목록 조회
     * - 고객ID 기준으로 조회
     */
    @ApiOperation(value = "회원 주문 정보 조회", notes = "사용자 정보를 조회한다.")
    @GetMapping("/member/orders")
    @ResponseStatus(HttpStatus.OK)
    public Response getMemberByParam(@ApiParam(value="회원아이디", required = true, example = "test") @RequestParam long id) {
        return Response.success(service.getMemberById(id));
    }

    /**
     * 여러 회원 조회, pagenation으로 단위 조절하여 조회
     * - 조회 조건 이름, 이메일
     * - 포함 내역 마지막 주문 정보
     */

    @ApiOperation(value = "모든 사용자 정보 조회", notes = "사용자 정보 전체를 조회한다.")
    @GetMapping("/member/all")
    @ResponseStatus(HttpStatus.OK)
    public Response getAllMember() {
        return Response.success(service.getAllMembers());
    }
}
