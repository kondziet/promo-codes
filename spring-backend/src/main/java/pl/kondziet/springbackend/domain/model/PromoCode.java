package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.kondziet.springbackend.domain.strategy.DiscountStrategy;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "PROMO_CODES")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PromoCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private LocalDateTime expiry;
    @Column(nullable = false)
    private Long maxAllowedUsages;

    public abstract DiscountStrategy getDiscountStrategy();
}
