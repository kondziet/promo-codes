package pl.kondziet.springbackend.infrastructure.web.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.kondziet.springbackend.domain.exception.DiscountCalculationException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DiscountCalculationHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DiscountCalculationException.class)
    public Map<String, Object> handleDiscountCalculation(DiscountCalculationException exception) {
        Map<String, Object> warningResponse = new HashMap<>();
        warningResponse.put("price", exception.getRegularPrice());
        warningResponse.put("warning", exception.getWarning());
        return warningResponse;
    }
}
