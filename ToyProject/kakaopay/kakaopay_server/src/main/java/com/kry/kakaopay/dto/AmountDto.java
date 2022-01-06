package com.kry.kakaopay.dto;

import lombok.Data;

@Data
public class AmountDto {
    int total;
    int tax_free;
    int vat;
    int point;
    int discount;
}
