package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.kondziet.springbackend.domain.strategy.DiscountStrategy;
import pl.kondziet.springbackend.domain.strategy.FixedAmountStrategy;

@AllArgsConstructor
@NoArgsConstructor
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
}
