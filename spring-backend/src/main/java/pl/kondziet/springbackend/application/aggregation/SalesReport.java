package pl.kondziet.springbackend.application.aggregation;

public record SalesReport(String currency, Double totalAmount, Double totalDiscount, Long noOfPurchases) {
}
