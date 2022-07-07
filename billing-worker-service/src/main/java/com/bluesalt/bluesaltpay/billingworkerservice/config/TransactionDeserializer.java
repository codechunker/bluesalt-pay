package com.bluesalt.bluesaltpay.billingworkerservice.config;

import com.bluesalt.bluesaltpay.shareddto.model.Transaction;
import com.bluesalt.bluesaltpay.shareddto.util.Contract;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class TransactionDeserializer implements Deserializer<Transaction> {

    @Override
    public Transaction deserialize(String s, byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException(Contract.DESERIALIZE_ERROR_MSG);
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(bytes, Transaction.class);
        } catch (IOException e) {
            throw new RuntimeException(Contract.DESERIALIZE_ERROR_MSG, e);
        }
    }
}
