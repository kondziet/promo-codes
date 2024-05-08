package pl.kondziet.springbackend.domain.strategy;

import pl.kondziet.springbackend.domain.model.Money;

public interface DiscountStrategy {

    Money calculateDiscount(Money regularPrice);

    default Money calculateDiscountedPrice(Money initialPrice) {
        Money discount = calculateDiscount(initialPrice);
        if (discount.isNegative()) {
            throw new IllegalArgumentException("Discount cannot be negative");
        }
        return initialPrice.subtract(discount);
    }
}
