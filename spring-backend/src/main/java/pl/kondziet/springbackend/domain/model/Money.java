package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.Embeddable;
import pl.kondziet.springbackend.application.dto.MoneyResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Embeddable
public record Money(Double amount, String currency) {

    public Money(Double amount, String currency) {
        if (amount == null || currency == null) {
            throw new IllegalArgumentException("Amount and currency must not be null");
        }
        this.amount = Money.parseToValidScale(amount);
        if (!isValidCurrency(currency)) {
            throw new IllegalArgumentException("Invalid currency code");
        }
        this.currency = currency;
    }

    public static Money zero(String currency) {
        return new Money(parseToValidScale(0d), currency);
    }

    public Money multiply(Double factor) {
        Double rawResult = amount * factor;
        Double parsedResult = Money.parseToValidScale(rawResult);
        return new Money(parsedResult, currency);
    }

    public Money subtract(Money other) {
        if (!this.currencyMatches(other)) {
            throw new IllegalArgumentException("Currencies must match for subtraction");
        }
        Double rawResult = amount - other.amount;
        Double parsedResult = Money.parseToValidScale(rawResult);
        return new Money(parsedResult, currency);
    }

    public boolean isZero() {
        return amount == 0;
    }

    public boolean isNegative() {
        return amount < 0;
    }

    public boolean isPositive() {
        return amount > 0;
    }

    public static Double parseToValidScale(Double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
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
        return new MoneyResponse(amount, currency);
    }
}
