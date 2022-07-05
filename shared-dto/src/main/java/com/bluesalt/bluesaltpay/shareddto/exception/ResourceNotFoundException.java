package com.bluesalt.bluesaltpay.shareddto.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
    private String code;

	private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String code, String message){
        super(message);
        this.code = code;
    }
}
