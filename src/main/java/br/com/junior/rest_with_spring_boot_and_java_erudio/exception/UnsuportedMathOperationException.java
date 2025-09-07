package br.com.junior.rest_with_spring_boot_and_java_erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {
    public UnsuportedMathOperationException(String message) {
        super(message);
    }
}
