package io.github.JoaoVianaSouza.service;

public class InvalidCepException extends RuntimeException {

    public InvalidCepException(String message, Throwable cause){
        super(message, cause);
    }

}
