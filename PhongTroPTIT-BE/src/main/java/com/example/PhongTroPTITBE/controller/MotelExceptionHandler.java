//package com.example.PhongTroPTITBE.controller;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class MotelExceptionHandler extends ResponseEntityExceptionHandler {
//
//
//    // handle custom exception
//    @ExceptionHandler(value = {
//            RuntimeException.class
//    })
//    public ResponseEntity<Object> handleNotExistResource(Exception ex) {
//        logger.error(String.format("Handle %s [status_code=%s, message=%s]",
//                ex.getClass().getSimpleName(), HttpStatus.BAD_REQUEST, ex.getMessage()));
//
//        Map<String, Object> objectMap = new LinkedHashMap<>();
//        objectMap.put("code", HttpStatus.BAD_REQUEST);
//        objectMap.put("message", ex.getMessage());
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(objectMap);
//    }
//
//    // handle another exception
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        logger.error(String.format("Handle %s [status_code=%s, message=%s]",
//                ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
//
//        Map<String, Object> objectMap = new LinkedHashMap<>();
//        objectMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
//        objectMap.put("message", ex.getMessage());
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(objectMap);
//    }
//}
//
