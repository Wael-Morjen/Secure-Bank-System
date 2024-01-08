package com.project.banksystem.service.impl;

import com.project.banksystem.dto.*;
import org.springframework.http.HttpHeaders;


public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    BankResponse balanceEnquiry(EnquiryRequest request);
    String nameEnquiry(EnquiryRequest request);
    BankResponse creditAccount(CreditDebitRequest request);
    BankResponse debitAccount(CreditDebitRequest request);
    BankResponse transfer(TransferRequest transferRequest, HttpHeaders headers);
    BankResponse login(LoginDto loginDto);
}
