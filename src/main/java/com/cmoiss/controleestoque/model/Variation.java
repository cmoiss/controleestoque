package com.cmoiss.controleestoque.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "variations")
public class Variation extends Entidade{
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "volume_variation_id")
    private VolumeVariation volumeVariations;

    @Column(name = "units_per_pack", nullable = false)
    private Integer unitsPerPack;

    public Variation(Product product, VolumeVariation volumeVariations, Integer unitsPerPack) {
        this.product = product;
        this.volumeVariations = volumeVariations;
        this.unitsPerPack = unitsPerPack;
    }
}
