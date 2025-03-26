package com.cmoiss.controleestoque.dao;

import com.cmoiss.controleestoque.model.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDAO extends GenericDAO<Categoria, Long> {
    public CategoriaDAO(EntityManager em) {
        super(Categoria.class, em);
    }
}
