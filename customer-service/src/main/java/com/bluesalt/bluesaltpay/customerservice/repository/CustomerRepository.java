package com.bluesalt.bluesaltpay.customerservice.repository;

import com.bluesalt.bluesaltpay.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long > {
}