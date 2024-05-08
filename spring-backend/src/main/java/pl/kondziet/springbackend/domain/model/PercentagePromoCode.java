package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "PERCENTAGE_PROMO_CODES")
public class PercentagePromoCode extends PromoCode {

    @Column(nullable = false)
    private Double percentage;
}
