package com.example.daelimdemo01.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StoreDto {
    String sigun;
    String name;
    String foodName;
    String tel;
    String addr;
}
