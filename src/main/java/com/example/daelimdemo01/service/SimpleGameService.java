package com.example.daelimdemo01.service;

import com.example.daelimdemo01.domain.dto.request.AddFoodReqDto;
import com.example.daelimdemo01.domain.dto.request.OrderFoodDto;
import com.example.daelimdemo01.domain.entity.Food;
import com.example.daelimdemo01.domain.entity.User;
import com.example.daelimdemo01.repository.FoodRepository;
import com.example.daelimdemo01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SimpleGameService {
    private final FoodRepository foodRepogitory;
    private final UserRepository userRepository;

    public Integer getRandomNumber(Integer max) {
        return (int) (Math.random() * max);
    }

    public String getRandomFood(String type) {
        String[] foods = {};
        if (type.equals("한식")) {
            foods = new String[]{"떡볶이", "국밥", "비빔밥"};
        } else if (type.equals("중식")) {
            foods = new String[]{"짜장면", "짬뽕", "탕수육"};
        } else if (type.equals("일식")) {
            foods = new String[]{"가츠동", "라멘", "스시"};
        }

        int randomNumber = (int) (Math.random() * foods.length);

        return foods[randomNumber];
    }

    public String addfood(AddFoodReqDto addFoodReqDto) {
        Food food = new Food();
        food.setName(addFoodReqDto.getName());
        food.setType(addFoodReqDto.getType());
        food.setPrice(addFoodReqDto.getPrice());

        foodRepogitory.save(food);

        return "success";
        //return type + "/" + food + "를 추가했습니다.";
    }

    public String getFoodById(Long id) {
        Optional<Food> foodOptional = foodRepogitory.findById(id);
        if (foodOptional.isEmpty()) {
            return "해당하는 ID의 음식이 없습니다";
        }

        Food food = foodOptional.get();
        return "success";
    }

    public List<String> getFoods() {
        List<Food> foods = foodRepogitory.findAll();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.get(i);
            result.add(food.getName() + " / " + food.getType() + " / " + food.getPrice());
        }

        return result;
    }

    public String deleteFoodById(Long id) {
        Optional<Food> foodOptional = foodRepogitory.findById(id);
        if (foodOptional.isPresent()) {
//            foodRepogitory.deleteById(id);
//            foodRepogitory.delete(foodOptional.get());
            foodOptional.get().delete();
            return "success";
        }

        return "찾을 수 없는 ID 입니다.";
    }

    public String getLottoNumber() {
        List<Integer> result = new ArrayList<Integer>();

        while (result.size() < 5) {
            int random = (int) (Math.random() * 45) + 1;
            if (result.contains(random)) {
                result.add(random);
            }
        }

        return result.toString();
    }

    public String updateFood(AddFoodReqDto addFoodReqDto) {
        Optional<Food> foodOptional = foodRepogitory.findByNameAndDeleted(addFoodReqDto.getName(), false);

        if (foodOptional.isPresent()) {
            Food food = foodOptional.get();
            food.setType(addFoodReqDto.getType());
            food.setPrice(addFoodReqDto.getPrice());
            return "success";
        }

        return "찾을 수 없는 name입니다.";
    }

    public String orderFood(OrderFoodDto orderFoodDto) {
        Optional<User> userOptional = userRepository.findById(orderFoodDto.getUserid());
        Optional<Food> FoodOptional = foodRepogitory.findByNameAndDeleted(orderFoodDto.getFoodName(), false);

        if (userOptional.isPresent() && FoodOptional.isPresent()) {
            User user = userOptional.get();
            Food food = FoodOptional.get();
            user.setMoney(user.getMoney() - food.getPrice());

            food.setOrderCount(food.getOrderCount() + 1);

            return "success";
        }

        return "fall";
    }
}

