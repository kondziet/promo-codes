package pl.kondziet.springbackend.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kondziet.springbackend.domain.model.PromoCode;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {
}
