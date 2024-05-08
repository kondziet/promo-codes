package pl.kondziet.springbackend.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kondziet.springbackend.domain.model.PercentagePromoCode;
import pl.kondziet.springbackend.infrastructure.persistence.repository.PromoCodeRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class ExemplaryDataInitializer implements CommandLineRunner {

    private final PromoCodeRepository promoCodeRepository;
    @Override
    public void run(String... args) throws Exception {

        var promo = PercentagePromoCode.builder()
                .code("asdasd")
                .expiry(LocalDateTime.now())
                .maxAllowedUsages(12L)
                .percentage(12.2)
                .build();

        promoCodeRepository.save(promo);
    }
}
