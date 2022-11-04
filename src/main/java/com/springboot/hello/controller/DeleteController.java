package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {
    // Path Variable로 URI에서 값 받기
    // http://localhost:8081/string-값-아무거나
    @DeleteMapping(value = "/hi/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    // RequestParm으로 URI에서 쿼리스트링 값 받기
    // http://localhost:8081/request1?email=value
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail: " + email;
    }
}
