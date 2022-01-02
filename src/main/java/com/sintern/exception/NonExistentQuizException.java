package com.sintern.exception;

public class NonExistentQuizException extends RuntimeException{
    public NonExistentQuizException(String message) {
        super(message);
    }
}
