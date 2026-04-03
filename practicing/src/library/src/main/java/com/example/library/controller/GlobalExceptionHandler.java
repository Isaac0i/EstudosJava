package com.example.library.controller;

import com.example.library.dto.ErroValidacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacao>> lidarComErroValidacao(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors().stream()
                .map(error -> new ErroValidacao(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(erros);
    }


}
