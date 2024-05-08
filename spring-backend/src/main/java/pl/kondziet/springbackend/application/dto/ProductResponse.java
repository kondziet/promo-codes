package pl.kondziet.springbackend.application.dto;

public record ProductResponse(String name, String description, MoneyResponse price) {
}
