package com.kimry.baedal.provider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseEntityProvider {

    public ResponseEntity<Map<String, String>> getMessage(String message, HttpStatus status){
        Map<String, String> body = new HashMap<>();
        body.put("message",message);
        return ResponseEntity.status(status).body(body);
    }
}
