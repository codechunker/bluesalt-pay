package com.bluesalt.bluesaltpay.shareddto.util;

public class Contract {
    public static final String TRANSACTION_TOPIC = "transaction-topic";
    public static final String FUNDING_TOPIC = "funding-topic";
    public static final String BILLING_GROUP_ID = "billing";
    public static final String TXN_GROUP_ID = "transaction";
    public static final String TXN_NOT_FOUND_MSG = "Transaction not found";
    public static final String CUS_NOT_FOUND_MSG = "Customer not found";
    public static final String DESERIALIZE_ERROR_MSG = "Error Deserializing message";

    public static class ResponseCode {
        public static final String ERROR_CODE = "BSP500";
        public static final String BAD_REQUEST_CODE = "BSP400";
        public static final String NOT_FOUND_CODE ="BSP404" ;
    }
}
