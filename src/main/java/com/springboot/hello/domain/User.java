package com.springboot.hello.domain;

public class User {
    private String name;
    private String id;
    private String password;

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String toString(){
        return String.format("User{id: %s, name: %s, password: %s}", id, name, password);
    }
}