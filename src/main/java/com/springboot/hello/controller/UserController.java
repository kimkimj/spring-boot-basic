package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<User> getUserId(@PathVariable String id) throws SQLException {
        User user = userDao.findById(id);
        return ResponseEntity.
                ok().
                body(user);
    }

    // client로 부터 UserRequestDto 객체를 생성할 parameter들을 받고 생성한다
    @PostMapping("/add")
    public ResponseEntity<Integer> addBody(@RequestBody User user) {
        return ResponseEntity
                .ok()
                .body(userDao.add(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable String id){
        return ResponseEntity
                .ok()
                .body(userDao.deleteById(id));
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Integer> deleteAll(){
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }

    @GetMapping("/selectAll")
    public String selectAll() {
        StringBuilder sb = new StringBuilder();
        List<User> users = userDao.selectAll();
        for (User user : users) {
            sb.append(user);
        }
        return sb.toString();
    }
}