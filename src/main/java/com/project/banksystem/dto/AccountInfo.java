package com.project.banksystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {

    private String accountName;

    private BigDecimal accountBalance;

    private String accountNumber;

    private String password;

    private  String status;

    private LocalDateTime createdAt;
}
