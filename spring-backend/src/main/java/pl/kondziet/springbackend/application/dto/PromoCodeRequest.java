package pl.kondziet.springbackend.application.dto;

import pl.kondziet.springbackend.domain.model.FixedAmountPromoCode;
import pl.kondziet.springbackend.domain.model.Money;
import pl.kondziet.springbackend.domain.model.PercentagePromoCode;
import pl.kondziet.springbackend.domain.model.PromoCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public sealed interface PromoCodeRequest permits FixedAmountPromoCodeRequest, PercentagePromoCodeRequest {

    String code();
    LocalDateTime expiry();
    Long maxAllowedUsages();
    default PromoCode toDomainObject() {
        return switch (this) {
            case FixedAmountPromoCodeRequest p -> FixedAmountPromoCode.builder()
                    .code(p.code())
                    .expiry(p.expiry())
                    .maxAllowedUsages(p.maxAllowedUsages())
                    .discount(new Money(
                            Money.parseToValidAmount(BigDecimal.valueOf(p.discount().amount())),
                            p.discount().currency()))
                    .build();
            case PercentagePromoCodeRequest p -> PercentagePromoCode.builder()
                    .code(p.code())
                    .expiry(p.expiry())
                    .maxAllowedUsages(p.maxAllowedUsages())
                    .percentage(p.percentage())
                    .build();
        };
    }
}
