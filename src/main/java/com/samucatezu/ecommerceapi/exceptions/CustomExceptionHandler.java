package com.samucatezu.ecommerceapi.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice()
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

  

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
                BindingResult result = ex.getBindingResult();
                List<FieldError> fieldErros = result.getFieldErrors();
                List<String> errors = new ArrayList<>();
                for(FieldError erro : fieldErros){
                    errors.add(erro.toString());
                }
                ApiErro reponse = new ApiErro("Erro ao validar campos", errors, HttpStatus.BAD_REQUEST);

                return new ResponseEntity<>(reponse, headers, reponse.getStatus());
    }
    
    
}
