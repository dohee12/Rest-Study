package com.example.daelimdemo01.controller;

import com.example.daelimdemo01.domain.dto.request.AddFoodReqDto;
import com.example.daelimdemo01.domain.dto.request.OrderFoodDto;
import com.example.daelimdemo01.service.SimpleGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SimpleGameController {
    private final SimpleGameService simpleGameService;

    @GetMapping("/get-random-number")
    public Integer getRandomNumber() {
        return simpleGameService.getRandomNumber(100);
    }

    @GetMapping("/get-random-number/{max}")
    public Integer getRandomNumber(@PathVariable("max") Integer max) {
        return simpleGameService.getRandomNumber(max);
    }

    @GetMapping("/get-random-food")
    public String getRandomFood(@RequestParam(value = "type", defaultValue = "한식") String type) {
        return simpleGameService.getRandomFood(type);
    }

    @PostMapping("/add-food")
    public String addFood(@RequestBody AddFoodReqDto addFoodReqDto) {
        return simpleGameService.addfood(addFoodReqDto);
    }

    @GetMapping("/get-food/{id}")
    public String getFood(@PathVariable("id") Long id) {
        return simpleGameService.getFoodById(id);
    }

    @GetMapping("/get-foods")
    public List<String> getFoods() {
        return simpleGameService.getFoods();
    }

    @GetMapping("/delete-food/{id}")
    public String deleteFood(@PathVariable("id") Long id) {
        return simpleGameService.deleteFoodById(id);
    }

    @GetMapping("/get-lotto-number")
    public String getLottoNumber() {
        return simpleGameService.getLottoNumber();
    }

    @GetMapping("/update-food")
    public String updateFood(@RequestBody AddFoodReqDto addFoodReqDto) {
        return simpleGameService.updateFood(addFoodReqDto);
    }
    // user id, food name을 보낸다
    // user id에 해당하는 user money에서 food price를 차감
    // food orderCount로 1 증가
    @PostMapping("/order-food")
    public String orderFood(@RequestBody OrderFoodDto orderFoodDto) {
        return simpleGameService.orderFood(orderFoodDto);
    }
}
