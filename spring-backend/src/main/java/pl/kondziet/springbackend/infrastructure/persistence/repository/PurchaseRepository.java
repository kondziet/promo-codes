package pl.kondziet.springbackend.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kondziet.springbackend.domain.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("""
    SELECT SUM(CAST(p.regularPrice.amount AS DOUBLE) - CAST(p.appliedDiscount.amount AS DOUBLE))
    FROM Purchase p
    GROUP BY p.regularPrice.currency
    """)
    Double countRaport();
    Long countByPromoCode_Id(Long promocodeId);
}
