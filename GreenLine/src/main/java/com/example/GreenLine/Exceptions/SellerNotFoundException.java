package com.example.GreenLine.Exceptions;

public class SellerNotFoundException extends RuntimeException {

    public SellerNotFoundException(String message) {
        super(message);
    }
}
