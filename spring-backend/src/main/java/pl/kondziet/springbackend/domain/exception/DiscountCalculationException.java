package pl.kondziet.springbackend.domain.exception;

import pl.kondziet.springbackend.application.dto.MoneyResponse;

public class DiscountCalculationException extends RuntimeException {

    private final MoneyResponse regularPrice;
    private final String warning;

    public DiscountCalculationException(MoneyResponse regularPrice, String warning) {
        super();
        this.regularPrice = regularPrice;
        this.warning = warning;
    }

    public MoneyResponse getRegularPrice() {
        return regularPrice;
    }

    public String getWarning() {
        return warning;
    }
}
