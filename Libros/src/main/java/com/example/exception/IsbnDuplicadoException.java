package com.example.exception;

public class IsbnDuplicadoException extends RuntimeException {
	public IsbnDuplicadoException(String message) {
        super(message);
    }
}
