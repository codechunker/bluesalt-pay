package com.bluesalt.bluesaltpay.billingservice.service;

import com.bluesalt.bluesaltpay.shareddto.dto.FundAccountRequest;
import com.bluesalt.bluesaltpay.shareddto.enums.FundStatus;
import com.bluesalt.bluesaltpay.shareddto.model.Transaction;
import com.bluesalt.bluesaltpay.shareddto.repository.TransactionRepository;
import com.bluesalt.bluesaltpay.shareddto.util.Contract;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillingService {

    private final TransactionRepository transactionRepository;
    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    @KafkaListener(topics = Contract.FUNDING_TOPIC, groupId = "billing")
    public void ListenAndSaveFundingRequest(FundAccountRequest request) throws JsonProcessingException {
        Transaction transaction = Transaction.builder()
                .customerId(request.getCustomerID())
                .tranReference(UUID.randomUUID().toString())
                .amount(request.getAmount())
                .status(FundStatus.PENDING)
                .build();
        transactionRepository.save(transaction);
        log.info("Pushing Funding Transaction to {} ", Contract.TRANSACTION_TOPIC);
        kafkaTemplate.send(Contract.TRANSACTION_TOPIC, transaction.getTranReference(), transaction);
    }
}
