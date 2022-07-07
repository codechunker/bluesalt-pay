package com.bluesalt.bluesaltpay.billingworkerservice.service;

import com.bluesalt.bluesaltpay.shareddto.enums.FundStatus;
import com.bluesalt.bluesaltpay.shareddto.model.Transaction;
import com.bluesalt.bluesaltpay.shareddto.repository.TransactionRepository;
import com.bluesalt.bluesaltpay.shareddto.util.Contract;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillingServiceWorker {

    private final TransactionRepository transactionRepository;

    /**
     * Gets pending transaction from Kafka
     * @param pendingTransaction transaction in transaction-topic
     */
    @KafkaListener(topics = {Contract.TRANSACTION_TOPIC}, groupId = Contract.TXN_GROUP_ID)
    public void creditAccount(Transaction pendingTransaction) throws InterruptedException {
        log.info("Received Transaction from {}", Contract.TRANSACTION_TOPIC);
        processSimulation();
        Optional<Transaction> tranDB = transactionRepository.findByTranReference(pendingTransaction.getTranReference());
        if (tranDB.isEmpty()) {//Prevent duplicate approval of transaction
            pendingTransaction.setStatus(FundStatus.SUCCESS);
            transactionRepository.save(pendingTransaction);
            log.info("Transaction with Reference {} Successfully updated", pendingTransaction.getTranReference());
        } else {
            log.info("Possible duplicate transaction");
        }
    }


    /**
     * Purely to simulate validations, API calls etc
     * before crediting an account
     */
    private void processSimulation() throws InterruptedException {
        Thread.sleep(100);
    }

}
