package com.example.daelimdemo01.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FoodStoreRowDto {
    @JsonProperty("SIGUN_NM")
    String SIGUN_NM;
    @JsonProperty("SIGUN_CD")
    String SIGUN_CD;
    @JsonProperty("RESTRT_NM")
    String RESTRT_NM;
    @JsonProperty("REPRSNT_FOOD_NM")
    String REPRSNT_FOOD_NM;
    @JsonProperty("TASTFDPLC_TELNO")
    String TASTFDPLC_TELNO;
    @JsonProperty("RM_MATR")
    String RM_MATR;
    @JsonProperty("REFINE_LOTNO_ADDR")
    String REFINE_LOTNO_ADDR;
    @JsonProperty("REFINE_ROADNM_ADDR")
    String REFINE_ROADNM_ADDR;
    @JsonProperty("REFINE_ZIP_CD")
    String REFINE_ZIP_CD;
    @JsonProperty("REFINE_WGS84_LOGT")
    String REFINE_WGS84_LOGT;
    @JsonProperty("REFINE_WGS84_LAT")
    String REFINE_WGS84_LAT;
}
