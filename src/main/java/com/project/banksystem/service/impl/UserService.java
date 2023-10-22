package com.project.banksystem.service.impl;

import com.project.banksystem.dto.BankResponse;
import com.project.banksystem.dto.CreditDebitRequest;
import com.project.banksystem.dto.EnquiryRequest;
import com.project.banksystem.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    BankResponse balanceEnquiry(EnquiryRequest request);
    String nameEnquiry(EnquiryRequest request);
    BankResponse creditAccount(CreditDebitRequest request);
}
