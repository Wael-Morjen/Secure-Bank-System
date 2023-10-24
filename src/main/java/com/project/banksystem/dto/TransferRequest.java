package com.project.banksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private Double amount;
}
