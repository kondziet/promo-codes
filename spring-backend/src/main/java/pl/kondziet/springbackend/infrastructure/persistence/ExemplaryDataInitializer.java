package pl.kondziet.springbackend.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kondziet.springbackend.application.dto.FixedAmountPromoCodeRequest;
import pl.kondziet.springbackend.application.dto.MoneyRequest;
import pl.kondziet.springbackend.application.dto.PercentagePromoCodeRequest;
import pl.kondziet.springbackend.application.dto.ProductRequest;
import pl.kondziet.springbackend.application.service.ProductService;
import pl.kondziet.springbackend.application.service.PromoCodeService;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class ExemplaryDataInitializer implements CommandLineRunner {

    private final PromoCodeService promoCodeService;
    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {

        var fixedAmountPromoCode1 = new FixedAmountPromoCodeRequest(
                "50USD",
                LocalDateTime.of(2024, 5, 10, 0, 0),
                2L,
                new MoneyRequest(50.55, "USD")
        );

        var fixedAmountPromoCode2 = new FixedAmountPromoCodeRequest(
                "20EUR",
                LocalDateTime.of(2024, 6, 30, 0, 0),
                3L,
                new MoneyRequest(20.75, "EUR")
        );

        var percentagePromoCode1 = new PercentagePromoCodeRequest(
                "15PERCENT",
                LocalDateTime.of(2024, 7, 1, 0, 0),
                15L,
                15.5
        );

        var percentagePromoCode2 = new PercentagePromoCodeRequest(
                "9PERCENT",
                LocalDateTime.of(2024, 8, 15, 0, 0),
                3L,
                9.25
        );

        promoCodeService.registerPromoCode(fixedAmountPromoCode1);
        promoCodeService.registerPromoCode(fixedAmountPromoCode2);
        promoCodeService.registerPromoCode(percentagePromoCode1);
        promoCodeService.registerPromoCode(percentagePromoCode2);

        var product1 = new ProductRequest(
                "Shoes",
                "Size: 9 US",
                new MoneyRequest(100.25, "USD")
        );

        var product2 = new ProductRequest(
                "TV",
                "Screen Size: 50 inches",
                new MoneyRequest(75.55, "EUR")
        );

        var product3 = new ProductRequest(
                "Large Hat",
                null,
                new MoneyRequest(15.23, "EUR")
        );

        productService.registerProduct(product1);
        productService.registerProduct(product2);
        productService.registerProduct(product3);

    }
}
