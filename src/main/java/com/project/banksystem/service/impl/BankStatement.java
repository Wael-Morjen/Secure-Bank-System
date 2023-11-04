package com.project.banksystem.service.impl;

import com.project.banksystem.entity.Transaction;
import com.project.banksystem.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BankStatement {

    private TransactionRepository transactionRepository;
    /*
     *  retrieve list of transactions within a date range given an account number
     *  generate a PDF file of transactions
     * send the file via email
     */

    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate) {
        List<Transaction> transactionList = transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getAccountNumber().equals(accountNumber))
                .filter(transaction -> transaction.get)
    }
}
