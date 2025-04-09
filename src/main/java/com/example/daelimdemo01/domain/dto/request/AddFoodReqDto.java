package com.example.daelimdemo01.domain.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AddFoodReqDto {
    private String name;
    private String type;
    private Integer price;

    // public
    // default
    // protected
    // private

//    public void setFood(String food) {
//        this.food = food;
//    }
//
//    public void setType(String type) {
//        // 의도한 것은 한식/중식/일식 중에 하나만
//        // 양식을 주입하면 안됨.
//
//        if (type.equals("한식") || type.equals("중식") || type.equals("일식")) {
//            this.type = type;
//        }
//    }
//
//    public String getFood() {
//        return food;
//    }
//
//    public String getType() {
//        return type;
//    }
}
