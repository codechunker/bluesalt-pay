package com.bluesalt.bluesaltpay.customerservice.api;

import com.bluesalt.bluesaltpay.customerservice.dto.FundAccountRequest;
import com.bluesalt.bluesaltpay.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(value = "fund", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> fundUserAccount(@RequestBody FundAccountRequest request) {
        customerService.fundAccount(request);
        return ResponseEntity.ok("success");
    }
}
