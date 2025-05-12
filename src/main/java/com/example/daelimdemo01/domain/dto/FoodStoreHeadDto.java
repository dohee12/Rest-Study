package com.example.daelimdemo01.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodStoreHeadDto {
    @JsonProperty("list_total_count")
    Long listTotalCount;
    @JsonProperty("api_version")
    String apiVersion;

    @JsonProperty("RESULT")
    FoodStoreResult result;
}
