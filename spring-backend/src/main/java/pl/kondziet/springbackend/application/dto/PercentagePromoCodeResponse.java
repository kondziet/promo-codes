package pl.kondziet.springbackend.application.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PercentagePromoCodeResponse(
        String code,
        LocalDateTime expiry,
        Long maxAllowedUsages,
        Double percentage

) implements PromoCodeResponse {
}
