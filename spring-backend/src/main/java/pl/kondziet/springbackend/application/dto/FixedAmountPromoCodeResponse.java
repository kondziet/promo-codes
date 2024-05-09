package pl.kondziet.springbackend.application.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FixedAmountPromoCodeResponse(
        String code,
        LocalDateTime expiry,
        Long maxAllowedUsages,
        MoneyResponse discount

) implements PromoCodeResponse {
}
