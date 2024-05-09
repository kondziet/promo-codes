package pl.kondziet.springbackend.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kondziet.springbackend.application.aggregation.DiscountDetails;
import pl.kondziet.springbackend.domain.model.Product;
import pl.kondziet.springbackend.domain.model.PromoCode;
import pl.kondziet.springbackend.domain.model.Purchase;
import pl.kondziet.springbackend.infrastructure.persistence.repository.ProductRepository;
import pl.kondziet.springbackend.infrastructure.persistence.repository.PromoCodeRepository;
import pl.kondziet.springbackend.infrastructure.persistence.repository.PurchaseRepository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class PurchaseService {

    private final DiscountService discountService;
    private final PromoCodeRepository promoCodeRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;

    @Transactional
    public void registerPurchase(Long productId, String code) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product doesn't exist"));
        PromoCode promoCode = promoCodeRepository.findByCode(code)
                .orElseThrow(() -> new NoSuchElementException("PromoCode doesn't exist"));

        DiscountDetails discountDetails = discountService.calculateDiscountDetails(productId, code);

        Purchase purchaseToPersist = Purchase.builder()
                .purchaseDate(LocalDateTime.now())
                .regularPrice(product.getPrice())
                .appliedDiscount(discountDetails.discount().toDomainObject())
                .promoCode(promoCode)
                .product(product)
                .build();

        purchaseRepository.save(purchaseToPersist);
    }
}
