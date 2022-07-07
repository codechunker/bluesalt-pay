package com.bluesalt.bluesaltpay.billingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableJpaRepositories({"com.bluesalt.bluesaltpay.shareddto.repository"})
@ComponentScan(basePackages = {"com.bluesalt.bluesaltpay" })
@EntityScan({"com.bluesalt.bluesaltpay.shareddto.model"})
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
        System.out.println("Application started");
    }

}
