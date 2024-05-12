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
            case FixedAmountPromoCodeRequest request -> FixedAmountPromoCode.builder()
                    .code(request.code())
                    .expiry(request.expiry())
                    .maxAllowedUsages(request.maxAllowedUsages())
                    .discount(request.discount().toDomainObject())
                    .build();

            case PercentagePromoCodeRequest request -> PercentagePromoCode.builder()
                    .code(request.code())
                    .expiry(request.expiry())
                    .maxAllowedUsages(request.maxAllowedUsages())
                    .percentage(request.percentage())
                    .build();
        };
    }
}
