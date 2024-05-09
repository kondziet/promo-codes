package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.kondziet.springbackend.application.dto.PromoCodeResponse;
import pl.kondziet.springbackend.domain.strategy.DiscountStrategy;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private LocalDateTime expiry;
    @Column(nullable = false)
    private Long maxAllowedUsages;
    @Builder.Default
    @OneToMany(mappedBy = "promoCode")
    private Set<Purchase> purchases = new HashSet<>();

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiry);
    }

    public abstract DiscountStrategy getDiscountStrategy();
    public abstract PromoCodeResponse toResponse();
}
