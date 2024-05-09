package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.Embeddable;
import pl.kondziet.springbackend.application.dto.MoneyResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Embeddable
public record Money(BigDecimal amount, String currency) {

    public Money {
        if (amount == null || currency == null) {
            throw new IllegalArgumentException("Amount and currency must not be null");
        }
        if (amount.scale() != 2) {
            throw new IllegalArgumentException("Amount scale must be exactly 2");
        }
        if (!isValidCurrency(currency)) {
            throw new IllegalArgumentException("Invalid currency code");
        }
    }

    public static Money zero(String currency) {
        return new Money(parseToValidAmount(BigDecimal.ZERO), currency);
    }

    public Money multiply(BigDecimal factor) {
        BigDecimal rawResult = amount.multiply(factor);
        BigDecimal roundedResult = Money.parseToValidAmount(rawResult);
        return new Money(roundedResult, currency);
    }

    public Money subtract(Money other) {
        if (!this.currencyMatches(other)) {
            throw new IllegalArgumentException("Currencies must match for subtraction");
        }
        BigDecimal rawResult = amount.subtract(other.amount);
        BigDecimal roundedResult = Money.parseToValidAmount(rawResult);
        return new Money(roundedResult, currency);
    }

    public boolean isZero() {
        return amount.compareTo(BigDecimal.ZERO) == 0;
    }

    public boolean isNegative() {
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }

    public boolean isPositive() {
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public static BigDecimal parseToValidAmount(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    public static boolean isValidCurrency(String currencyCode) {
        try {
            Currency.getInstance(currencyCode);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean currencyMatches(Money other) {
        return currency.equals(other.currency);
    }

    public MoneyResponse toResponse() {
        return new MoneyResponse(amount.doubleValue(), currency);
    }
}
