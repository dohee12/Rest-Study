package com.example.daelimdemo01.service;


import com.example.daelimdemo01.domain.dto.FoodStoreDto;
import com.example.daelimdemo01.domain.dto.FoodStoreRowDto;
import com.example.daelimdemo01.domain.dto.PlaceThatDoATasteyFoodStDto;
import com.example.daelimdemo01.domain.dto.StoreDto;
import com.example.daelimdemo01.feign.GGClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GGService {
    private final GGClient ggClient;

    public List<StoreDto> getPlaceThatDoATasteyFoodSt(
            Integer pIndex, Integer pSize, String SIGUN_NM
    ) throws JsonProcessingException {
        List<StoreDto> storeDtoList = new ArrayList<>();

        String jsonString = ggClient.getPlaceThatDoATasteyFoodSt(
                "ec10983c11ae42fbad7a78a8950f0203",
                "json",
                pIndex, pSize, SIGUN_NM
        );
        ObjectMapper objectMapper = new ObjectMapper();
        FoodStoreDto foodStoreDto = objectMapper.readValue(jsonString, FoodStoreDto.class);
        PlaceThatDoATasteyFoodStDto placeThatDoATasteyFoodStDto = foodStoreDto.getPlaceThatDoATasteyFoodStDtoSt().get(0);

        for (int i = 0; i < placeThatDoATasteyFoodStDto.getRow().size(); i++) {
            FoodStoreRowDto foodStoreRowDto = placeThatDoATasteyFoodStDto.getRow().get(i);
            StoreDto storeDto = new StoreDto();
            storeDto.setName(foodStoreRowDto.getRESTRT_NM());
            storeDto.setSigun(foodStoreRowDto.getSIGUN_NM());
            storeDto.setFoodName(foodStoreRowDto.getREPRSNT_FOOD_NM());
            storeDto.setAddr(foodStoreRowDto.getREFINE_LOTNO_ADDR());
            storeDto.setTel(foodStoreRowDto.getTASTFDPLC_TELNO());

            storeDtoList.add(storeDto);
        }

        return storeDtoList;
    }
}
