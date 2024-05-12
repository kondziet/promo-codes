package pl.kondziet.springbackend.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kondziet.springbackend.application.aggregation.SalesReport;
import pl.kondziet.springbackend.domain.model.Purchase;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("""
    SELECT new pl.kondziet.springbackend.application.aggregation.SalesReport(
        p.regularPrice.currency,
        SUM(p.regularPrice.amount),
        SUM(p.appliedDiscount.amount),
        COUNT(p.id)
    )
    FROM Purchase p
    GROUP BY p.regularPrice.currency
    """)
    List<SalesReport> findAllSalesReports();

    Long countByPromoCode_Id(Long promocodeId);
}
