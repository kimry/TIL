package com.kry.kakaopay.dto;

import lombok.Data;

import java.util.Date;

@Data
public class KakaoPayReadyDto {
    String tid;
    String next_redirect_app_url;
    String next_redirect_mobile_url;
    String next_redirect_pc_url;
    String android_app_scheme;
    String ios_app_scheme;
    Date create_at;
}
