package com.kimry.baedal.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kimry.baedal.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {

    @JsonProperty("passenger")
    PASSENGER("passenger"),
    @JsonProperty("driver")
    DRIVER("driver");

    private String type;

    public static UserType value(String userType){
        if(userType.equals("passenger")) {
            return PASSENGER;
        }
        else if(userType.equals("driver"))
        {
            return DRIVER;
        }
        throw new CustomException(ErrorCode.USER_TYPE_INVALID);
    }

}