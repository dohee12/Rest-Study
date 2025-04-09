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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String addUser(UserDto addUserReqDto) {
        User user = new User();
        user.setNickname(addUserReqDto.getNickname());
        user.setAge(addUserReqDto.getAge());
        user.setMoney(addUserReqDto.getMoney());

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

        List<UserDto> addUserReqDtos = new ArrayList<>();
        for (User user : users) {
            addUserReqDtos.add(new UserDto(user));
        }

        return addUserReqDtos;

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
