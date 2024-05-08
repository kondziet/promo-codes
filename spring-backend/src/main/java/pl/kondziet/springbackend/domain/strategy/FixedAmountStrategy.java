package pl.kondziet.springbackend.domain.strategy;

import pl.kondziet.springbackend.domain.model.Money;
import pl.kondziet.springbackend.domain.model.Product;

public record FixedAmountStrategy(Money discount) implements DiscountStrategy {

    @Override
    public Money calculatePrice(Product product) {
        return null;
    }
}
