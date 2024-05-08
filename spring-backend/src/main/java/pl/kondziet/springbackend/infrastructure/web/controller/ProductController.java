package pl.kondziet.springbackend.infrastructure.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kondziet.springbackend.application.dto.ProductRequest;
import pl.kondziet.springbackend.application.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        productService.registerProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    ResponseEntity<?> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.retrieveAllProducts());
    }

    @PutMapping("/{productId}")
    ResponseEntity<?> updateProduct(@Valid @RequestBody ProductRequest productRequest, @PathVariable Long productId) {
        productService.modifyProduct(productRequest, productId);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
