package com.kimry.baedal.service;

import com.kimry.baedal.domain.Users;
import com.kimry.baedal.enums.UserType;
import com.kimry.baedal.repository.UsersRepository;
import com.kimry.baedal.util.CurrentDateProvider;
import com.kimry.baedal.util.ResponseEntityProvider;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    CurrentDateProvider currentDateProvider;

    @Autowired
    ResponseEntityProvider responseEntityProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsersRepository usersRepository;

    public ResponseEntity<Object> signUp(String email, String password, UserType userType){

        if(!EmailValidator.getInstance().isValid(email)){
            return responseEntityProvider.getMessage("올바른 이메일을 입력해주세요",HttpStatus.BAD_REQUEST);
        }

        Users users = Users.builder().
                email(email).
                password(passwordEncoder.encode(password)).
                userType(userType).
                createdAt(currentDateProvider.getDate()).
                updatedAt(currentDateProvider.getDate()).
                build();

        usersRepository.save(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    public boolean validatePassword(String email, String password){

        Optional<Users> users = usersRepository.findByEmail(email);

        if(users.isPresent()){
            return passwordEncoder.matches(password,users.get().getPassword());
        }

        return false;

    }
}
