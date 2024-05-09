package pl.kondziet.springbackend.infrastructure.web.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class IllegalArgumentHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleConflictException(IllegalArgumentException exception) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", exception.getMessage());
        return errorResponse;
    }
}
