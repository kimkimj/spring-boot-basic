package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PostController {
    // TEST API에서 POST형식으로 요청을 넣어야만 결과값을 받을 수 있다

    // RequestMapping으로 POST형식의 request만 받는다
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    // RequestBODY
    // POST 요청에서 resource를 담기 위해서는 HTTP Body 값에 넣어 전송한다
    // Map 형식으로 데이터를 받는다
    @PostMapping(value="/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }
}
