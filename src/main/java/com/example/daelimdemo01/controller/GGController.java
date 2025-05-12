package com.example.daelimdemo01.controller;

import com.example.daelimdemo01.domain.dto.StoreDto;
import com.example.daelimdemo01.service.GGService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GGController {
    private final GGService ggService;

    @GetMapping("/get-food-store")
    public List<StoreDto> getFoodStore(
            @RequestParam Integer pIndex, @RequestParam Integer pSize, @RequestParam String SIGUN_NM
    ) throws JsonProcessingException {
        return ggService.getPlaceThatDoATasteyFoodSt(pIndex, pSize, SIGUN_NM);
    }
}
