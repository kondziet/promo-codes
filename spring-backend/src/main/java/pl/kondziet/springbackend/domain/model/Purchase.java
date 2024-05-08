package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PURCHASES")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime purchaseDate;
    @AttributeOverrides({
            @AttributeOverride(name="amount",
                    column=@Column(name="PRICE_AMOUNT")),
            @AttributeOverride(name="currency",
                    column=@Column(name="PRICE_CURRENCY"))
    })
    @Embedded
    @Column(nullable = false)
    private Money regularPrice;
    @AttributeOverrides({
            @AttributeOverride(name="amount",
                    column=@Column(name="DISCOUNT_AMOUNT")),
            @AttributeOverride(name="currency",
                    column=@Column(name="DISCOUNT_CURRENCY"))
    })
    @Embedded
    private Money appliedDiscount;
    @ManyToOne
    private Product product;
}
