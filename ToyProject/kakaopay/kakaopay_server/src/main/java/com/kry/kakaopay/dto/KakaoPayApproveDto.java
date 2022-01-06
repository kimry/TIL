package com.kry.kakaopay.dto;

import lombok.Data;

import java.util.Date;

@Data
public class KakaoPayApproveDto {
    String aid;
    String tid;
    String partner_order_id;
    String partner_user_id;
    String payment_method_type;
    AmountDto amount;
    CardInfoDto card_info;
    String item_name;
    String item_code;
    int quantity;
    Date created_at;
    Date approved_at;
    String payload;
}
