package com.kimry.baedal.controller;

import com.kimry.baedal.enums.UserType;
import com.kimry.baedal.vo.SignInVO;
import com.kimry.baedal.vo.SignUpVO;
import com.kimry.baedal.domain.User;
import com.kimry.baedal.provider.CurrentDateProvider;
import com.kimry.baedal.service.UserService;
import com.kimry.baedal.provider.ResponseEntityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/users")
public class UsersController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    CurrentDateProvider currentDateProvider;

    @PostMapping(value="/sign-in")
    public ResponseEntity<Map<String, String>> signIn(@RequestBody SignInVO signInVO){

        String token = userService.signIn(signInVO.getEmail(), signInVO.getPassword());

        Map<String, String> message = new HashMap<>();
        message.put("accessToken",token);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(value="/sign-up")
    public ResponseEntity<User> signUp(@RequestBody SignUpVO signUpVO){

        User user = userService.signUp(signUpVO.getEmail(),signUpVO.getPassword(), UserType.value(signUpVO.getUserType()));

        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
}
