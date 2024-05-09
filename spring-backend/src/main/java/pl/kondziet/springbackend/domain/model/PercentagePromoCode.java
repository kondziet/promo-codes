package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.kondziet.springbackend.application.dto.PercentagePromoCodeResponse;
import pl.kondziet.springbackend.application.dto.PromoCodeResponse;
import pl.kondziet.springbackend.domain.strategy.DiscountStrategy;
import pl.kondziet.springbackend.domain.strategy.PercentageAmountStrategy;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "PERCENTAGE_PROMO_CODES")
public class PercentagePromoCode extends PromoCode {

    @Column(nullable = false)
    private Double percentage;
    @Override
    public DiscountStrategy getDiscountStrategy() {
        return new PercentageAmountStrategy(percentage);
    }

    @Override
    public PromoCodeResponse toResponse() {
        return PercentagePromoCodeResponse.builder()
                .code(super.getCode())
                .expiry(super.getExpiry())
                .maxAllowedUsages(super.getMaxAllowedUsages())
                .percentage(percentage)
                .build();
    }
}
