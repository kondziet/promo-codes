package pl.kondziet.springbackend.infrastructure.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kondziet.springbackend.application.dto.FixedAmountPromoCodeRequest;
import pl.kondziet.springbackend.application.dto.PercentagePromoCodeRequest;
import pl.kondziet.springbackend.application.dto.ProductRequest;
import pl.kondziet.springbackend.application.dto.PromoCodeRequest;
import pl.kondziet.springbackend.application.service.PromoCodeService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/promocode")
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    @GetMapping
    ResponseEntity<?> getAllPromoCodes() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(promoCodeService.retrieveAllPromoCodes());
    }

    @PostMapping("/fixed-amount")
    public ResponseEntity<String> createFixedAmountPromoCode(@RequestBody FixedAmountPromoCodeRequest promoCodeRequest) {
        promoCodeService.registerPromoCode(promoCodeRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/percentage")
    public ResponseEntity<String> createPercentagePromoCode(@RequestBody PercentagePromoCodeRequest promoCodeRequest) {
        promoCodeService.registerPromoCode(promoCodeRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
