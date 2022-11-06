package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/get/{id}")
    public String getUserId(@PathVariable String id) throws SQLException {
        User user = userDao.findById(id);
        return user.toString();
    }

    // client로 부터 UserRequestDto 객체를 생성할 parameter들을 받고 생성한다
    @PostMapping("/add")
    public void addBody(@RequestBody User user) {
        userDao.add(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        userDao.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll(){
        userDao.deleteAll();
    }
}
