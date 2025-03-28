package com.cmoiss.controleestoque.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductTest {
    @Test
    void testeDeInstancia() {
        Product p1 = new Product();
        Product p2 = new Product("Coca cola", new Categoria("Bebidas"));
    }
}