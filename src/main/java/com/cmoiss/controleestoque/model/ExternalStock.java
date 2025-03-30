package com.cmoiss.controleestoque.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "external_stock")
public class ExternalStock extends Entidade {
    @OneToOne
    @JoinColumn(name = "variation_id")
    Variation variation;

    @Column(name = "quantity_of_packs", nullable = false)
    Integer quantityOfPacksInExternalStock;

    public ExternalStock(Variation variation, Integer quantityOfPacksInExternalStock) {
        this.variation = variation;
        this.quantityOfPacksInExternalStock = quantityOfPacksInExternalStock;
    }
}
