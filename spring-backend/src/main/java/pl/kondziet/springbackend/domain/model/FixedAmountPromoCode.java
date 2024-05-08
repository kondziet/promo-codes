package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "FIXED_AMOUNT_PROMO_CODES")
public class FixedAmountPromoCode extends PromoCode {

    @Embedded
    @Column(nullable = false)
    private Money discount;
}
