package com.example.daelimdemo01.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodStoreResult {
    @JsonProperty("CODE")
    String CODE;
    @JsonProperty("MESSAGE")
    String MESSAGE;
}
