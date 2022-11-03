package com.springboot.hello.dto;

public class MemberDto {
    private String name;
    private String email;
    private String organization;

    // getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return String.format("MemberDto{name='%s', email='%s', organization='%s'}", name, email, organization);
    }
}
