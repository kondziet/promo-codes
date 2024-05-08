package pl.kondziet.springbackend.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MoneyRequest(
        @NotNull(message = "Amount is required")
        Double amount,
        @NotBlank(message = "Currency is required")
        String currency
) {
}
