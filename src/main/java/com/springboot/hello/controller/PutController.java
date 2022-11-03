package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PutController {

    // @RequestBody: POST method와 마찬가지로 값을 HTTP Body에 담아 전달하고,
    // 서버는 이 값을 받기 위해 @RequestBody를 사용한다

    // 서버에 어떤 값이 들어오는지 모르는 경우에는 Map 객체를 활용
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();
        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // DTO 객체를 활용
    // String 반환
    @PutMapping(value = "/member1 ")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    // DTO 객체 반환
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    //ResponseEntity
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.
                status(HttpStatus.ACCEPTED).
                body(memberDto);
    }


}
