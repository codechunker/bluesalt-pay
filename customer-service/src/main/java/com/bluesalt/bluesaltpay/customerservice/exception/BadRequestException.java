package com.bluesalt.bluesaltpay.customerservice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @Author Remy Ohajinwa
 * @create 5/07/2022
 */

@Data
public class BadRequestException extends RuntimeException {

    private String code;
    private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    private void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public BadRequestException(String message, List<Error> errors) {
        super(message);

        setErrors(errors);
    }

    public BadRequestException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
