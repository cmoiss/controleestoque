package com.cmoiss.controleestoque.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CategoriaTest {
    @Test
    void testaInstanciaDeCategoria() {
        Categoria categoria = new Categoria();
        assertNotNull(categoria);
    }

    @Test
    void testaInstanciaDeCategoriaComNome() {
        Categoria categoria = new Categoria("Eletrônicos");
        assertEquals("Eletrônicos", categoria.getNome());
    }
}