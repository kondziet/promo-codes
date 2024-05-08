package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("PERCENTAGE")
public class PercentagePromoCode extends PromoCode {

    private Double percentage;
}
