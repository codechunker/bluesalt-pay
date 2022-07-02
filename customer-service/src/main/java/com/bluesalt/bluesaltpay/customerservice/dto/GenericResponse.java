package com.bluesalt.bluesaltpay.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String status;
    private String message;
    private T data;
    private String code;
    private LocalDateTime date = LocalDateTime.now();

    public GenericResponse(String status, String message, T data, String code) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.code = code;
    }

}
