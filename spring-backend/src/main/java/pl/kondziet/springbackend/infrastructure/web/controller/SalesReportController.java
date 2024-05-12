package pl.kondziet.springbackend.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kondziet.springbackend.application.service.SalesReportService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/report")
public class SalesReportController {

    private final SalesReportService salesReportService;

    @GetMapping
    ResponseEntity<?> generateReport() {
        return ResponseEntity.ok(salesReportService.generateSalesReport());
    }
}
