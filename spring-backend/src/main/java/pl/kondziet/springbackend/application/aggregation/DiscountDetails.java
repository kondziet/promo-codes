package pl.kondziet.springbackend.application.aggregation;

import pl.kondziet.springbackend.application.dto.MoneyResponse;

public record DiscountDetails(MoneyResponse discount, MoneyResponse discountedPrice) {
}
