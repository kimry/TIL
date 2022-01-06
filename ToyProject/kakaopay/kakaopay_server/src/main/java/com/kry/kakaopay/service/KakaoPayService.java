package com.kry.kakaopay.service;

import com.kry.kakaopay.dto.KakaoPayApproveDto;
import com.kry.kakaopay.dto.KakaoPayReadyDto;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class KakaoPayService {

    //결제준비
    public KakaoPayReadyDto ready(String userId, String product, int price, int quantity){

        //URL 부분
        MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
        header.add("Authorization","KakaoAK ");
        header.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //Parameter 부분
        MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
        param.add("cid","TC0ONETIME");
        param.add("partner_order_id","1");
        param.add("partner_user_id",userId);
        param.add("item_name",product);
        param.add("quantity",Integer.toString(quantity));
        param.add("total_amount",Integer.toString(price*quantity));
        param.add("tax_free_amount","0");
        param.add("approval_url","http://localhost:8080/Client/success.html?userId="+userId);
        param.add("cancel_url","http://localhost:8080/Client/cancel.html");
        param.add("fail_url","http://localhost:8080/Client/fail.html");

        HttpEntity<MultiValueMap<String,String>> body = new HttpEntity<MultiValueMap<String,String>>(param, header);

        KakaoPayReadyDto kakaoPayReadyDto = null;
        RestTemplate restTemplate = new RestTemplate();

        try {
            kakaoPayReadyDto =restTemplate.postForObject(new URI("https://kapi.kakao.com/v1/payment/ready"),body, KakaoPayReadyDto.class);
        } catch(Exception e){
            e.printStackTrace();
        }

        return kakaoPayReadyDto;
    }

    //결제요청
    public KakaoPayApproveDto approve(String userId, String pg_token, String tid){

        //URL 부분
        MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
        header.add("Authorization","KakaoAK ");
        header.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //Parameter 부분
        MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
        param.add("cid","TC0ONETIME");
        param.add("tid",tid);
        param.add("partner_order_id","1");
        param.add("partner_user_id",userId);
        param.add("pg_token",pg_token);

        HttpEntity<MultiValueMap<String,String>> body = new HttpEntity<MultiValueMap<String,String>>(param, header);

        KakaoPayApproveDto kakaoPayApproveDto = null;
        RestTemplate restTemplate = new RestTemplate();

        try {
            kakaoPayApproveDto =restTemplate.postForObject(new URI("https://kapi.kakao.com/v1/payment/approve"),body, KakaoPayApproveDto.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return kakaoPayApproveDto;
    }
}
