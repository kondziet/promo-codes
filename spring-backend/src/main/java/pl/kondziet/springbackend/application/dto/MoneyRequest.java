package pl.kondziet.springbackend.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.kondziet.springbackend.domain.model.Money;

public record MoneyRequest(
        @NotNull(message = "Amount is required")
        Double amount,
        @NotBlank(message = "Currency is required")
        String currency
) {

    public Money toDomainObject() {
        return new Money(amount, currency);
    }
}
