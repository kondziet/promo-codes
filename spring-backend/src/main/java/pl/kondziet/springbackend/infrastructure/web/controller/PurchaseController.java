package pl.kondziet.springbackend.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kondziet.springbackend.application.service.PurchaseService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/{productId}")
    public ResponseEntity<?> createPurchase(@PathVariable Long productId, @RequestParam String promocode) {
        purchaseService.registerPurchase(productId, promocode);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
