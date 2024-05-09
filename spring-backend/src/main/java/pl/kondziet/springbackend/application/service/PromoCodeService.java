package pl.kondziet.springbackend.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kondziet.springbackend.application.dto.PromoCodeRequest;
import pl.kondziet.springbackend.application.dto.PromoCodeResponse;
import pl.kondziet.springbackend.domain.model.PromoCode;
import pl.kondziet.springbackend.infrastructure.persistence.repository.PromoCodeRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;

    public List<PromoCodeResponse> retrieveAllPromoCodes() {
        return promoCodeRepository.findAll().stream().map(PromoCode::toResponse).toList();
    }

    public void registerPromoCode(PromoCodeRequest promoCodeRequest) {
        PromoCode promoCodeToPersist = promoCodeRequest.toDomainObject();

        promoCodeRepository.save(promoCodeToPersist);
    }
}
