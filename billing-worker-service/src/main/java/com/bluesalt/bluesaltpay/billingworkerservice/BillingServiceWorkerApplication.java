package com.bluesalt.bluesaltpay.billingworkerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"com.bluesalt.bluesaltpay.shareddto.repository"})
@ComponentScan(basePackages = {"com.bluesalt.bluesaltpay" })
@EntityScan({"com.bluesalt.bluesaltpay.shareddto.model"})
public class BillingServiceWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceWorkerApplication.class, args);
    }

}
