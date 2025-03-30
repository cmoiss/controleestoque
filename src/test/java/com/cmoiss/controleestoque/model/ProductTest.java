package com.cmoiss.controleestoque.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductTest {
    @Test
    void testeDeInstancia() {
        Product p1 = new Product();
        Product p2 = new Product("Coca cola", new Categoria("Bebidas"));
        VolumeVariation vv1 = new VolumeVariation(500, 10.0, 7, p2);
        VolumeVariation vv2 = new VolumeVariation(1000, 12.0, 10, p2);
        Variation v = new Variation(p2, vv1, 12);
        ExternalStock es1 = new ExternalStock(v, 3);
    }
}