package pl.kondziet.springbackend.application.dto;

import java.time.LocalDateTime;

public sealed interface PromoCodeResponse permits FixedAmountPromoCodeResponse, PercentagePromoCodeResponse {
    String code();
    LocalDateTime expiry();
    Long maxAllowedUsages();
}
