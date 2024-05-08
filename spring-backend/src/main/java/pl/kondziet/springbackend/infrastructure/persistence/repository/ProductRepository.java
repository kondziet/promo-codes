package pl.kondziet.springbackend.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kondziet.springbackend.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
