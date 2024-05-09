package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.kondziet.springbackend.application.dto.FixedAmountPromoCodeResponse;
import pl.kondziet.springbackend.application.dto.MoneyResponse;
import pl.kondziet.springbackend.application.dto.PromoCodeResponse;
import pl.kondziet.springbackend.domain.strategy.DiscountStrategy;
import pl.kondziet.springbackend.domain.strategy.FixedAmountStrategy;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "FIXED_AMOUNT_PROMO_CODES")
public class FixedAmountPromoCode extends PromoCode {

    @Embedded
    @Column(nullable = false)
    private Money discount;
    @Override
    public DiscountStrategy getDiscountStrategy() {
        return new FixedAmountStrategy(discount);
    }

    @Override
    public PromoCodeResponse toResponse() {
        return FixedAmountPromoCodeResponse.builder()
                .code(super.getCode())
                .expiry(super.getExpiry())
                .maxAllowedUsages(super.getMaxAllowedUsages())
                .discount(new MoneyResponse(
                        discount.amount().doubleValue(),
                        discount.currency()
                ))
                .build();
    }
}
