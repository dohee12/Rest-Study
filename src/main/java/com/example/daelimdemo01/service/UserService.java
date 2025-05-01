package com.example.daelimdemo01.service;

import com.example.daelimdemo01.domain.dto.request.IncreaseMoneyDto;
import com.example.daelimdemo01.domain.dto.request.UserDto;
import com.example.daelimdemo01.domain.entity.User;
import com.example.daelimdemo01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String addUser(UserDto userDto) {
        User user = new User();
        user.setNickname(userDto.getNickname());
        user.setAge(userDto.getAge());
        user.setMoney(userDto.getMoney());

        userRepository.save(user);

        return "success";
    }

    public UserDto getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            return new UserDto(user);
        }

        return null;
    }

    public UserDto getUserByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname);
        if (user != null) {
            return new UserDto(user);
        }

        return null;
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(new UserDto(user));
        }
        return userDtos;

//        return users.stream()
//                .map(user -> new UserDto(user))
//                .collect(Collectors.toList());
    }

    public String deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.delete();
            userRepository.save(user);
            return "success";
        }

        return "fail";
    }

    public String increaseMoney(IncreaseMoneyDto increaseMoneyDto) {
        Optional<User> userOptional = userRepository.findById(increaseMoneyDto.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setMoney(user.getMoney() + increaseMoneyDto.getMoney());
            userRepository.save(user);
            return "success";
        }

        return "fail";
    }


}