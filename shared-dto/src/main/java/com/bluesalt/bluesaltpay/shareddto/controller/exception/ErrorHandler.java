/**
 * @project bluesalt-pay
 * @author Remy Ohajinwa
 * Created 05-Jul-22
 */
package com.bluesalt.bluesaltpay.shareddto.controller.exception;

import com.bluesalt.bluesaltpay.shareddto.dto.GenericResponse;
import com.bluesalt.bluesaltpay.shareddto.exception.BadRequestException;
import com.bluesalt.bluesaltpay.shareddto.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.bluesalt.bluesaltpay.shareddto.util.Contract.ResponseCode.BAD_REQUEST_CODE;
import static com.bluesalt.bluesaltpay.shareddto.util.Contract.ResponseCode.ERROR_CODE;

@Slf4j
@ResponseBody
@ControllerAdvice(annotations = RestController.class, basePackages = "com.bluesalt.bluesaltpay")
public class ErrorHandler {


    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public GenericResponse<?> handleBadRequestException(BadRequestException e) {
        log.error("", e);
        GenericResponse<?> response = new GenericResponse<>();
        response.setCode(e.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage(e.getMessage());

        return response;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public GenericResponse<?> handleCustomValidationException(MethodArgumentNotValidException e) {
        log.error("", e);
        GenericResponse<?> response = new GenericResponse<>();
        response.setCode(ERROR_CODE);
        response.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());

        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public GenericResponse<?> handleException(Exception e) {
        log.error("",e);

        GenericResponse<?> response = new GenericResponse<>();
        response.setCode(ERROR_CODE);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setMessage("An error occurred while processing your request. " +
                "Please contact Server Administrator for more details: "
        );
        return response;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public GenericResponse<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error("", e);
        GenericResponse<?> response = new GenericResponse<>();
        response.setCode(BAD_REQUEST_CODE);
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        return response;
    }
}
//To God be the Glory
