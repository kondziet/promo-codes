package pl.kondziet.springbackend.domain.strategy;

import pl.kondziet.springbackend.domain.model.Money;

public interface DiscountStrategy {

    Money calculateDiscount(Money regularPrice);
    Money calculateDiscountedPrice(Money initialPrice);
}
