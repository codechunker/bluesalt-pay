package com.bluesalt.bluesaltpay.customerservice.api;

import com.bluesalt.bluesaltpay.customerservice.service.CustomerService;
import com.bluesalt.bluesaltpay.shareddto.dto.FundAccountRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private static final String REQUEST_MAPPING = "/api/v1/customers";

    private static ObjectMapper objectMapper;

    @BeforeAll
    static void init() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void contextLoads() {

    }

    @Description("Test Funding account by Customer should return OK 200")
    @Test
    void GivenPayload_WhenFunds_ThenReturn200() throws Exception {
        FundAccountRequest request = FundAccountRequest.builder()
                .customerID(1L)
                .amount(BigDecimal.valueOf(1000L))
                .email("admin@admin.com")
                .build();
        Mockito.doNothing().when(customerService).fundAccount(request);
        mockMvc.perform(MockMvcRequestBuilders.post(REQUEST_MAPPING + "/fund")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Description("Given a bad payload, this endpoint should return 400")
    @Test
    void GivenBadPayload_WhenFunds_ThenReturn400() throws Exception {
        FundAccountRequest request = FundAccountRequest.builder().build();
        Mockito.doNothing().when(customerService).fundAccount(request);
        mockMvc.perform(MockMvcRequestBuilders.post(REQUEST_MAPPING + "/fund")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}
