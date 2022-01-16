package com.kimry.baedal.controller;

import com.kimry.baedal.util.CurrentDateProvider;
import com.kimry.baedal.domain.Users;
import com.kimry.baedal.enums.UserType;
import com.kimry.baedal.service.UsersService;
import com.kimry.baedal.util.ResponseEntityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UsersController {

    @Autowired
    ResponseEntityProvider responseEntityProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsersService usersService;

    @Autowired
    CurrentDateProvider currentDateProvider;

    @PostMapping(value="/sign-in")
    public ResponseEntity<Object> signIn(String email, String password){


        if(usersService.validatePassword(email, password))
        {
            return responseEntityProvider.getMessage("성공",HttpStatus.CREATED);
        }
        return responseEntityProvider.getMessage("올바른 이메일을 입력해주세요", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value="/sign-up")
    public ResponseEntity<Object> signUp(String email, String password, UserType userType){

        return usersService.signUp(email, password, userType);
    }
}
