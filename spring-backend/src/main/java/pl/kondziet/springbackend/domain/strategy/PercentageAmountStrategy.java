package pl.kondziet.springbackend.domain.strategy;

import pl.kondziet.springbackend.domain.model.Money;
import pl.kondziet.springbackend.domain.model.Product;

import java.math.BigDecimal;

public record PercentageAmountStrategy(Double percentage) implements DiscountStrategy {

    @Override
    public Money calculatePrice(Product product) {
        Money regularPrice = product.getPrice();

        Money discount = regularPrice.multiply(BigDecimal.valueOf(percentage/100));
        Money discountedPrice = regularPrice.subtract(discount);

        return discountedPrice.isNegative() ? Money.zero(regularPrice.currency()) : discountedPrice;
    }
}
