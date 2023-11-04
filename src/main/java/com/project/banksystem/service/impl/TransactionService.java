package com.project.banksystem.service.impl;

import com.project.banksystem.dto.TransactionDto;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
