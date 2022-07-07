package com.bluesalt.bluesaltpay.billingservice.config;

import com.bluesalt.bluesaltpay.shareddto.dto.FundAccountRequest;
import com.bluesalt.bluesaltpay.shareddto.util.Contract;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class FundAccountRequestDeserializer implements Deserializer<FundAccountRequest> {


    @Override
    public FundAccountRequest deserialize(String s, byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException(Contract.DESERIALIZE_ERROR_MSG);
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(bytes, FundAccountRequest.class);
        } catch (IOException e) {
            throw new RuntimeException(Contract.DESERIALIZE_ERROR_MSG, e);
        }
    }
}
