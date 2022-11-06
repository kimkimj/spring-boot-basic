package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String id;
    private String name;

    public static UserResponseDto form(User user) {
        return new UserResponseDto(user.getId(), user.getName());
    }

}
