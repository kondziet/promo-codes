package pl.kondziet.springbackend.domain.strategy;

import org.junit.jupiter.api.Test;
import pl.kondziet.springbackend.domain.model.Money;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FixedAmountStrategyTest {

    @Test
    void shouldCalculateNotExceedingDiscountCorrectly() {
        //given:
        var regularPrice = new Money(BigDecimal.valueOf(65.25), "USD");
        var strategy = new FixedAmountStrategy(new Money(BigDecimal.valueOf(37.35), "USD"));

        //when:
        var discount = strategy.calculateDiscount(regularPrice);

        //then:
        assertEquals(new Money(BigDecimal.valueOf(37.35), "USD"), discount);
    }

    @Test
    void shouldCalculateExceedingDiscountCorrectly() {
        //given:
        var regularPrice = new Money(BigDecimal.valueOf(65.25), "USD");
        var strategy = new FixedAmountStrategy(new Money(BigDecimal.valueOf(82.35), "USD"));

        //when:
        var discount = strategy.calculateDiscount(regularPrice);

        //then:
        assertEquals(new Money(BigDecimal.valueOf(65.25), "USD"), discount);
    }

    @Test
    void shouldCalculateNotExceedingDiscountedPriceCorrectly() {
        //given:
        var regularPrice = new Money(BigDecimal.valueOf(65.25), "USD");
        var strategy = new FixedAmountStrategy(new Money(BigDecimal.valueOf(37.35), "USD"));

        //when:
        var discountedPrice = strategy.calculateDiscountedPrice(regularPrice);

        //then:
        assertEquals(new Money(new BigDecimal("27.90"), "USD"), discountedPrice);
    }

    @Test
    void shouldCalculateExceedingDiscountedPriceCorrectly() {
        //given:
        var regularPrice = new Money(BigDecimal.valueOf(65.25), "USD");
        var strategy = new FixedAmountStrategy(new Money(BigDecimal.valueOf(99.35), "USD"));

        //when:
        var discountedPrice = strategy.calculateDiscountedPrice(regularPrice);

        //then:
        assertEquals(Money.zero("USD"), discountedPrice);
    }
}