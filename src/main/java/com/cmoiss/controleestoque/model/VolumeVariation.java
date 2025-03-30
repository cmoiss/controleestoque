package com.cmoiss.controleestoque.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "volume_variations")
@Setter
public class VolumeVariation extends Entidade {
    @Column(name = "volume_value", nullable = false)
    private Integer volumeValue; // Deve ser medido em ml

    @Column(columnDefinition = "decimal(10,2) default 0.00")
    private Double price;

    @Column(name = "quantity_in_stock", nullable = false, columnDefinition = "decimal(10,2) default 0.00")
    private Integer quantityInInternalStock;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public VolumeVariation(Integer volumeValue, Double price, Integer quantityInInternalStock, Product product) {
        this.volumeValue = volumeValue;
        this.price = price;
        this.quantityInInternalStock = quantityInInternalStock;
        this.product = product;
    }
}
