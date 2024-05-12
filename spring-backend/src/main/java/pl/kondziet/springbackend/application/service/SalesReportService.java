package pl.kondziet.springbackend.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kondziet.springbackend.application.aggregation.SalesReport;
import pl.kondziet.springbackend.infrastructure.persistence.repository.PurchaseRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SalesReportService {

    private final PurchaseRepository purchaseRepository;

    public List<SalesReport> generateSalesReport() {
        return purchaseRepository.findAllSalesReports();
    }
}
