package com.cmoiss.controleestoque.service;

import com.cmoiss.controleestoque.dao.CategoriaDAO;
import com.cmoiss.controleestoque.dao.ProductDAO;
import com.cmoiss.controleestoque.model.Categoria;
import com.cmoiss.controleestoque.model.Product;
import com.cmoiss.controleestoque.util.TestJPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductServiceTest {
    private final EntityManager em = TestJPAUtil.createTestEntityManager();
    private final ProductService service = new ProductService(em);

    @BeforeEach
    void init() {
        TestJPAUtil.limparBanco(em);
    }

    @Test
    void testaInsercaoDeProdutosNoBanco() {
        Categoria c = new Categoria("Refrigerante");
        Product p = new Product("Coca cola", c);

        service.save(p);

        assertEquals(p, service.findByName(p.getNome()));
    }
}