package com.project.banksystem.repository;

import com.project.banksystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    public List<Transaction> findAllTransactionByAccountNumber(String accountNumber);
}
