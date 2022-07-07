package com.bluesalt.bluesaltpay.customerservice.config;

import com.bluesalt.bluesaltpay.customerservice.model.Customer;
import com.bluesalt.bluesaltpay.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProjectConfig {

    private final CustomerRepository customerRepository;

    @PostConstruct
    public void seedCustomers() {
        List<Customer> customers = List.of(
                new Customer("John", "Doe", "johndoe@bluesalt.com", "123456"),
                new Customer("Sarah", "Jones", "sarahjone@bluesalt.com", "789012"),
                new Customer("Harry", "Phils", "harryphils@bluesalt.com", "46898234")
        );
        customerRepository.saveAll(customers);
        log.info("Customers successfully seeded");
    }
}
