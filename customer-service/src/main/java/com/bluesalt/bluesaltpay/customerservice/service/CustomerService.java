package com.bluesalt.bluesaltpay.customerservice.service;

import com.bluesalt.bluesaltpay.shareddto.dto.FundAccountRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CustomerService {
    void fundAccount(FundAccountRequest request) throws JsonProcessingException;
}
