package com.kry.kakaopay.controller;

import com.kry.kakaopay.dto.KakaoPayApproveDto;
import com.kry.kakaopay.dto.KakaoPayReadyDto;
import com.kry.kakaopay.service.KakaoPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class payController {

    @Autowired
    KakaoPayService pService;

    //결제준비
    @RequestMapping(value = "ready", method = RequestMethod.POST)
    public KakaoPayReadyDto ready(String userId,String product, int price, int quantity){
        System.out.println("payController ready()");

        KakaoPayReadyDto kakaoPayReadyDto = pService.ready(userId, product,price,quantity);

        return kakaoPayReadyDto;
    }

    //결제요청
    @RequestMapping(value="approve", method = RequestMethod.POST)
    public KakaoPayApproveDto approve(String userId, String pg_token, String tid){
        System.out.println("payController approve()");

        KakaoPayApproveDto kakaoPayApproveDto = pService.approve(userId, pg_token, tid);

        return kakaoPayApproveDto;
    }
}
