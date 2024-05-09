package pl.kondziet.springbackend.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kondziet.springbackend.application.aggregation.DiscountDetails;
import pl.kondziet.springbackend.domain.exception.DiscountCalculationException;
import pl.kondziet.springbackend.domain.model.FixedAmountPromoCode;
import pl.kondziet.springbackend.domain.model.Money;
import pl.kondziet.springbackend.domain.model.Product;
import pl.kondziet.springbackend.domain.model.PromoCode;
import pl.kondziet.springbackend.domain.strategy.DiscountStrategy;
import pl.kondziet.springbackend.infrastructure.persistence.repository.ProductRepository;
import pl.kondziet.springbackend.infrastructure.persistence.repository.PromoCodeRepository;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class DiscountService {

    private final ProductRepository productRepository;
    private final PromoCodeRepository promoCodeRepository;

    @Transactional
    public DiscountDetails calculateDiscountDetails(Long productId, String code) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product doesn't exist"));
        PromoCode promoCode = promoCodeRepository.findByCode(code)
                .orElseThrow(() -> new NoSuchElementException("PromoCode doesn't exist"));

        if (promoCode.isExpired()) {
            throw new DiscountCalculationException(product.getPrice().toResponse(), "PromoCode is expired");
        }

        if (promoCode instanceof FixedAmountPromoCode pc && !pc.getDiscount().currencyMatches(product.getPrice())) {
            throw new DiscountCalculationException(product.getPrice().toResponse(), "PromoCode currency doesn't match the product currency");
        }

        Long numberOfUsages = promoCodeRepository.findNumberOfUsages(product.getId());
        if (numberOfUsages >= promoCode.getMaxAllowedUsages()) {
            throw new DiscountCalculationException(product.getPrice().toResponse(), "PromoCode usage limit has been exceeded");
        }

        DiscountStrategy discountStrategy = promoCode.getDiscountStrategy();
        Money discount = discountStrategy.calculateDiscount(product.getPrice());
        Money discountedPrice = discountStrategy.calculateDiscountedPrice(product.getPrice());

        return new DiscountDetails(discount.toResponse(), discountedPrice.toResponse());
    }
}
