package pl.kondziet.springbackend.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(String name, String description, MoneyResponse price) {
}
