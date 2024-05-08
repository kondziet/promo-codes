package pl.kondziet.springbackend.application.dto;

public record ProductRequest(String name, String description, MoneyRequest price) {
}
