package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class GetController {

    // Request Mapping: HTTP의 모든 요청을 받는다
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    // GetMapping: GET형식의 요청만 받는다
    // 매개변수가 없는 요청
    //localhost:8081/cat 이렇게 요청하면 정해진 응답을 반환
    @GetMapping("/cat")
    public String getName() {
        return "Lulu the Cat";
    }

    // 실무에서는 위처럼 매개변수를 받지 않는 매서드는 거의 쓰이지 않음
    // url 자체에 값을 담아 요청
    // {} 이 안에 client가 매개변수에 넣고 싶은 값을 입력하면, spring boot app이
    // 그 변수를 사용함
    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    // PathVariable과 GetMapping의 변수이름을 동일시 할 수 없을 때
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String lulu){
        return lulu;
    }

    // client가 url/request1/name=value&email=value&organization=value
    // 이런 식으로 url로 요청한다
    @GetMapping(value="/request1")
    public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
        return String.format("%s \n%s \n%s\n", name, email, organization);
    }

    // 만약 어떤 값이 들어올 지 모른다면
   @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        // save every entry as map and get its key and value
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + ": " + map.getValue() + "\n");
        });
        return sb.toString();
   }

    //DTO 객체를 활용한 GET 메서드 구현
    // localhost:8081/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

}
