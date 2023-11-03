package com.project.banksystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {

    @Schema(
            name = "User account name"
    )
    private String accountName;

    @Schema(
            name = "User account balance"
    )
    private BigDecimal accountBalance;

    @Schema(
            name = "User account account number"
    )
    private String accountNumber;

    @Schema(
            name = "User account account status"
    )
    private  String status;
}
