package com.bluesalt.bluesaltpay.customerservice.service.impl;

import com.bluesalt.bluesaltpay.customerservice.config.KafkaConfig;
import com.bluesalt.bluesaltpay.customerservice.dto.FundAccountRequest;
import com.bluesalt.bluesaltpay.customerservice.model.Customer;
import com.bluesalt.bluesaltpay.customerservice.repository.CustomerRepository;
import com.bluesalt.bluesaltpay.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final KafkaConfig kafkaConfig;
    private final KafkaTemplate<String, FundAccountRequest> fundingTemplate;


    @Override
    public void fundAccount(FundAccountRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerID())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found!"));

        fundingTemplate.send(kafkaConfig.getTopicName(), request.getCustomerID().toString(), request);
    }
}
