package com.springboot.hello.dto;

public class UserRequestDto {
    private String name;
    private String id;
    private String password;

    public UserRequestDto(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
