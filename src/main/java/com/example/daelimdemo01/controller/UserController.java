package com.example.daelimdemo01.controller;

import com.example.daelimdemo01.domain.dto.request.IncreaseMoneyDto;
import com.example.daelimdemo01.domain.dto.request.UserDto;
import com.example.daelimdemo01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // add-user
    @PostMapping("/add-user")
    public String addUser(@RequestBody UserDto addUserReqDto) {
        return userService.addUser(addUserReqDto);
    }
    // get-user-by-id
    @PostMapping("/get-user-by-id")
    public UserDto getUserById(@RequestBody UserDto addUserReqDto) {
        return userService.getUserById(addUserReqDto.getId());
    }
    // get-user-by-nickname
    @GetMapping("/get-user-by-nickname")
    public UserDto getUserByNickname(@RequestParam String nickname) {
        return userService.getUserByNickname(nickname);
    }
    // get-users (money가 많은 순)
    @GetMapping("/get-users")
    public List<UserDto> getUser() {
        return userService.getUsers();
    }
    // delete-user (id로 한명 찾아서 soft delete)
    @PostMapping("/delete-user")
    public String deleteUser(@RequestBody UserDto userDto) {
        return userService.deleteUser(userDto.getId());
    }
    // increase-money (id로 한명 찾아서 money 수치 바꾸기)
    @PostMapping("/increase-money")
    public String increaseMoney(@RequestBody IncreaseMoneyDto increaseMoneyDto) {
        return userService.increaseMoney(increaseMoneyDto);
    }
}
