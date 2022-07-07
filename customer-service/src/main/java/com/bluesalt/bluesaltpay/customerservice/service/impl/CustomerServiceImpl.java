package com.bluesalt.bluesaltpay.customerservice.service.impl;

import com.bluesalt.bluesaltpay.customerservice.config.KafkaConfig;
import com.bluesalt.bluesaltpay.customerservice.model.Customer;
import com.bluesalt.bluesaltpay.customerservice.repository.CustomerRepository;
import com.bluesalt.bluesaltpay.customerservice.service.CustomerService;
import com.bluesalt.bluesaltpay.shareddto.dto.FundAccountRequest;
import com.bluesalt.bluesaltpay.shareddto.exception.ResourceNotFoundException;
import com.bluesalt.bluesaltpay.shareddto.util.Contract;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.bluesalt.bluesaltpay.shareddto.util.Contract.*;
import static com.bluesalt.bluesaltpay.shareddto.util.Contract.ResponseCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final KafkaConfig kafkaConfig;
    private final KafkaTemplate<String, FundAccountRequest> fundingTemplate;


    @Override
    public void fundAccount(FundAccountRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerID())
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_CODE, CUS_NOT_FOUND_MSG));
        String topicName = kafkaConfig.getTopicName();
        log.info("Publishing Customer ID {} to {} For Billing Service", request.getCustomerID(), topicName);
        fundingTemplate.send(topicName, request.getCustomerID().toString(), request);//TODO Maybe RESTful
    }
}
