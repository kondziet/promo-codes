package pl.kondziet.springbackend.domain.strategy;

import pl.kondziet.springbackend.domain.model.Money;
import pl.kondziet.springbackend.domain.model.Product;

public interface DiscountStrategy {

    Money calculatePrice(Product product);
}
