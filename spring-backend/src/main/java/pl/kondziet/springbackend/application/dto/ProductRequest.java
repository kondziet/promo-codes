package pl.kondziet.springbackend.application.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        String name,
        @Size(max = 500, message = "Description cannot exceed 500 characters")
        @Nullable
        String description,
        @Valid
        @NotNull(message = "Price is required")
        MoneyRequest price
) {
}
