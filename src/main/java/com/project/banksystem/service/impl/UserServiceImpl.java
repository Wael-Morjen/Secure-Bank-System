package com.project.banksystem.service.impl;

import com.project.banksystem.dto.BankResponse;
import com.project.banksystem.dto.UserRequest;
import com.project.banksystem.entity.User;

public class UserServiceImpl implements UserService {

    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
         * Creating an account - saving a new user into the DB
         */
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .StateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber()
                .build();
    }
}
