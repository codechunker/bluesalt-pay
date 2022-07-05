package com.bluesalt.bluesaltpay.shareddto.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FundAccountRequest {

    @NotNull(message = "Customer ID is required")
    private Long customerID;
    @NotEmpty(message = "Email is required")
    private String email;
    @Min(value = 1, message = "Invalid amount supplied")
    private BigDecimal amount;
}
