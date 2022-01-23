package com.kimry.baedal.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaxiRequestStatus {
    @JsonProperty("standBy")
    STAND_BY("standBy"),
    @JsonProperty("accepted")
    ACCEPTED("accepted");

    private String status;

}
