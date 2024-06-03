package com.example.PhongTroPTITBE.exception;

public class ImageException extends RuntimeException {
    public ImageException(String message) {
        super(message);
    }

    public ImageException(String message, Throwable cause) {
        super(message, cause);
    }
}