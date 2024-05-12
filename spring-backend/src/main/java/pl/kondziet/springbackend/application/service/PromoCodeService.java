package pl.kondziet.springbackend.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kondziet.springbackend.application.aggregation.PromoCodeDetails;
import pl.kondziet.springbackend.application.dto.PromoCodeRequest;
import pl.kondziet.springbackend.application.dto.PromoCodeResponse;
import pl.kondziet.springbackend.domain.model.PromoCode;
import pl.kondziet.springbackend.infrastructure.persistence.repository.PromoCodeRepository;
import pl.kondziet.springbackend.infrastructure.persistence.repository.PurchaseRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;
    private final PurchaseRepository purchaseRepository;

    public List<PromoCodeResponse> retrieveAllPromoCodes() {
        return promoCodeRepository.findAll().stream().map(PromoCode::toResponse).toList();
    }

    @Transactional
    public void registerPromoCode(PromoCodeRequest promoCodeRequest) {
        PromoCode promoCodeToPersist = promoCodeRequest.toDomainObject();

        if (promoCodeRepository.existsByCode(promoCodeToPersist.getCode())) {
            throw new IllegalArgumentException("PromoCode with given code already exists");
        }

        promoCodeRepository.save(promoCodeToPersist);
    }

    @Transactional
    public PromoCodeDetails retrievePromoCodeDetails(String code) {
        PromoCode promoCode = promoCodeRepository.findByCode(code)
                .orElseThrow(() -> new NoSuchElementException("PromoCode doesn't exist"));

        Long usageCount = purchaseRepository.countByPromoCode_Id(promoCode.getId());

        return PromoCodeDetails.builder()
                .promoCode(promoCode.toResponse())
                .usageCount(usageCount)
                .build();
    }
}
