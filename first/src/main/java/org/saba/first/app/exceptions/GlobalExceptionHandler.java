package org.saba.first.app.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(
            IllegalArgumentException  exception
    ){
        Map<String,Object> errorResponce = new HashMap<>();
        errorResponce.put("message",exception.getMessage());
        return new ResponseEntity<>(errorResponce, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Map<String,Object>> handleMethodNotsupported(
            Exception  exception
    ){
        Map<String,Object> errorResponce = new HashMap<>();
        errorResponce.put("message",exception.getMessage());
        return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
    }
}
