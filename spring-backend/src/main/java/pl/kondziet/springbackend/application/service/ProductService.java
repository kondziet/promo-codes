package pl.kondziet.springbackend.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kondziet.springbackend.application.dto.MoneyResponse;
import pl.kondziet.springbackend.application.dto.ProductRequest;
import pl.kondziet.springbackend.application.dto.ProductResponse;
import pl.kondziet.springbackend.domain.model.Money;
import pl.kondziet.springbackend.domain.model.Product;
import pl.kondziet.springbackend.infrastructure.persistence.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void registerProduct(ProductRequest productRequest) {
        var productToPersist = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(new Money(
                        Money.parseToValidAmount(BigDecimal.valueOf(productRequest.price().amount())),
                        productRequest.price().currency()))
                .build();

        productRepository.save(productToPersist);
    }

    public List<ProductResponse> retrieveAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(
                        product.getName(),
                        product.getDescription(),
                        new MoneyResponse(
                                product.getPrice().amount().doubleValue(),
                                product.getPrice().currency()
                        )
                ))
                .toList();
    }

    public void modifyProduct(ProductRequest productRequest, Long productId) {
        var persistedProduct = productRepository.findById(productId).orElseThrow();

        persistedProduct.setName(productRequest.name());
        persistedProduct.setDescription(productRequest.description());
        persistedProduct.setPrice(new Money(
                Money.parseToValidAmount(BigDecimal.valueOf(productRequest.price().amount())),
                productRequest.price().currency()));

        productRepository.saveAndFlush(persistedProduct);
    }
}
