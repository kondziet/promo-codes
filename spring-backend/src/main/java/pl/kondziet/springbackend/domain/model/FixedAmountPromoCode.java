package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("FIXED_AMOUNT")
public class FixedAmountPromoCode extends PromoCode {

    @Embedded
    private Money discount;
}
