package pl.kondziet.springbackend.application.aggregation;

import lombok.Builder;
import pl.kondziet.springbackend.application.dto.PromoCodeResponse;

@Builder
public record PromoCodeDetails(PromoCodeResponse promoCode, Long usageCount) {
}
