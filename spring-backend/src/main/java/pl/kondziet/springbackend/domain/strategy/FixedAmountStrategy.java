package pl.kondziet.springbackend.domain.strategy;

import pl.kondziet.springbackend.domain.model.Money;

public record FixedAmountStrategy(Money discount) implements DiscountStrategy {

    @Override
    public Money calculateDiscount(Money regularPrice) {
        Money rawDiscount = discount;
        Money discountedPrice = regularPrice.subtract(rawDiscount);

        return discountedPrice.isNegative() ? regularPrice : rawDiscount;
    }
}
