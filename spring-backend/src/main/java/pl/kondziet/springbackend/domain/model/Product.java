package pl.kondziet.springbackend.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Embedded
    @Column(nullable = false)
    private Money price;
    @Builder.Default
    @OneToMany(mappedBy = "product")
    private Set<Purchase> purchases = new HashSet<>();
}
