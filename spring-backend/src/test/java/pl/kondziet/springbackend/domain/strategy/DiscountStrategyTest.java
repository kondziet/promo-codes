package pl.kondziet.springbackend.domain.strategy;

import org.junit.jupiter.api.Test;
import pl.kondziet.springbackend.domain.model.Money;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DiscountStrategyTest {

    @Test
    void negativeDiscountShouldThrowException() {
        //given:
        var regularPrice = new Money(25.25, "USD");
        var strategy = new DiscountStrategy() {
            @Override
            public Money calculateDiscount(Money regularPrice) {
                return regularPrice.subtract(new Money(120.25, "USD"));
            }
        };

        //expect:
        assertThrows(IllegalArgumentException.class, () -> strategy.calculateDiscountedPrice(regularPrice));
    }

}