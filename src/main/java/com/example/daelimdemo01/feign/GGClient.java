package com.example.daelimdemo01.feign;

import com.example.daelimdemo01.config.FeignConfig;
import com.example.daelimdemo01.domain.dto.PlaceThatDoATasteyFoodStDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gg", url = "https://openapi.gg.go.kr", configuration = FeignConfig.class)
public interface GGClient {
    @GetMapping("/PlaceThatDoATasteyFoodSt")
    String getPlaceThatDoATasteyFoodSt(
            @RequestParam String Key,
            @RequestParam String Type,
            @RequestParam Integer pIndex,
            @RequestParam Integer pSize
    );

    @GetMapping("/PlaceThatDoATasteyFoodSt")
    String getPlaceThatDoATasteyFoodSt(
            @RequestParam String Key,
            @RequestParam String Type,
            @RequestParam Integer pIndex,
            @RequestParam Integer pSize,
            @RequestParam String SIGUN_NM
    );
}
