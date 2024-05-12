package pl.kondziet.springbackend.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.kondziet.springbackend.application.dto.validation.NoWhitespace;
import pl.kondziet.springbackend.application.dto.validation.TrimmedSize;

import java.time.LocalDateTime;

public record PercentagePromoCodeRequest(
        @NotBlank(message = "Code is required")
        @TrimmedSize(min = 3, max = 24)
        @NoWhitespace
        String code,
        @NotNull(message = "Expiry is required")
        LocalDateTime expiry,
        @NotNull(message = "Max Allowed Usages is required")
        Long maxAllowedUsages,
        @NotNull(message = "Percentage is required")
        Double percentage

) implements PromoCodeRequest {
}
