package pl.kondziet.springbackend.domain.strategy;

import pl.kondziet.springbackend.domain.model.Money;

import java.math.BigDecimal;

public record PercentageAmountStrategy(Double percentage) implements DiscountStrategy {

    @Override
    public Money calculateDiscount(Money regularPrice) {
        Money rawDiscount = regularPrice.multiply(percentage/100);
        Money discountedPrice = regularPrice.subtract(rawDiscount);

        return discountedPrice.isNegative() ? regularPrice : rawDiscount;
    }
}
