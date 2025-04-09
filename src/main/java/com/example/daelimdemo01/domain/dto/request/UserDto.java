package com.example.daelimdemo01.domain.dto.request;

import com.example.daelimdemo01.domain.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String nickname;
    private Integer age;
    private Long money;

    public UserDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.age = user.getAge();
        this.money = user.getMoney();
    }
}

