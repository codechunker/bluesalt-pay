package com.bluesalt.bluesaltpay.shareddto.model;


import com.bluesalt.bluesaltpay.shareddto.enums.FundStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private String tranReference;
    private BigDecimal amount;
    @Enumerated
    private FundStatus status;
}
