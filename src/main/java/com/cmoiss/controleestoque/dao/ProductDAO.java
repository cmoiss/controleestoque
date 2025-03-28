package com.cmoiss.controleestoque.dao;

import com.cmoiss.controleestoque.model.Product;
import jakarta.persistence.EntityManager;

public class ProductDAO extends GenericDAO<Product, Long> {
    public ProductDAO(EntityManager em) {
        super(Product.class, em);
    }
}
