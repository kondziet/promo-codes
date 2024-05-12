package pl.kondziet.springbackend.application.dto;

import pl.kondziet.springbackend.domain.model.Money;

import java.math.BigDecimal;

public record MoneyResponse(Double amount, String currency) {

    public Money toDomainObject() {
        return new Money(amount, currency);
    }
}
