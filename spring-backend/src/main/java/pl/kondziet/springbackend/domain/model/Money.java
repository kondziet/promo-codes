package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record Money(BigDecimal amount, String currency) {

    public Money {
        if (amount == null || currency == null) {
            throw new IllegalArgumentException("Amount and currency must not be null");
        }
        if (amount.scale() != 2) {
            throw new IllegalArgumentException("Amount scale must be exactly 2");
        }
    }
}
