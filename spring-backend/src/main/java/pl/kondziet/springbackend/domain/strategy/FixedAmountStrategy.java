package pl.kondziet.springbackend.domain.strategy;

import pl.kondziet.springbackend.domain.model.FixedAmountPromoCode;
import pl.kondziet.springbackend.domain.model.Money;
import pl.kondziet.springbackend.domain.model.Product;

public record FixedAmountStrategy(FixedAmountPromoCode fixedAmountPromoCode) implements DiscountStrategy {

    @Override
    public Money calculatePrice(Product product) {
        return null;
    }
}
