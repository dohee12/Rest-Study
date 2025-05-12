package com.example.daelimdemo01.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlaceThatDoATasteyFoodStDto {
    List<FoodStoreHeadDto> head;
    List<FoodStoreRowDto> row;
}
