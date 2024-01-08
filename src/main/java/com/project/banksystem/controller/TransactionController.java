package com.project.banksystem.controller;

import com.itextpdf.text.DocumentException;
import com.project.banksystem.entity.Transaction;
import com.project.banksystem.repository.TransactionRepository;
import com.project.banksystem.service.impl.BankStatement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/bankStatement")
@AllArgsConstructor
public class TransactionController {

    private BankStatement bankStatement;
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> generateBankStatement(@RequestParam String accountNumber,
                                                   @RequestParam String startDate,
                                                   @RequestParam String endDate) throws DocumentException, IOException {
        return bankStatement.generateBankStatement(accountNumber, startDate, endDate);
    }

    @GetMapping("/getAllTransactions")
    public List<Transaction> getAllTransactions(@RequestParam String account){
        return transactionRepository.findAllTransactionByAccountNumber(account);
    }
}
