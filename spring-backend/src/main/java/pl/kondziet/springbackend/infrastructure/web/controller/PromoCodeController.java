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

    @GetMapping("/{code}")
    public ResponseEntity<?> getPromoCodeDetails(@PathVariable String code) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(promoCodeService.retrievePromoCodeDetails(code));
    }

    @PostMapping("/fixed-amount")
    public ResponseEntity<?> createFixedAmountPromoCode(@Valid @RequestBody FixedAmountPromoCodeRequest promoCodeRequest) {
        promoCodeService.registerPromoCode(promoCodeRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/percentage")
    public ResponseEntity<?> createPercentagePromoCode(@Valid @RequestBody PercentagePromoCodeRequest promoCodeRequest) {
        promoCodeService.registerPromoCode(promoCodeRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
