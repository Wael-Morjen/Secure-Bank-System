package com.project.banksystem.service.impl;

import com.project.banksystem.dto.BankResponse;
import com.project.banksystem.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
