package com.bluesalt.bluesaltpay.customerservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundAccountRequest {
    private Long customerID;
    private String email;
    private BigDecimal amount;
}
