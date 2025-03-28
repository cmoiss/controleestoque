package com.cmoiss.controleestoque.service.strategy;

import com.cmoiss.controleestoque.dao.GenericDAO;
import com.cmoiss.controleestoque.model.EntidadeNomeada;
import jakarta.persistence.EntityExistsException;

public class ValidacaoObjetoExiste<T extends EntidadeNomeada> implements ValidacaoStrategy<T> {
    GenericDAO<T, Long> dao;

    public ValidacaoObjetoExiste(GenericDAO<T, Long> dao) {
        this.dao = dao;
    }

    @Override
    public void validar(T product) {
        if (dao.findByName(product.getNome()) != null) throw new EntityExistsException("Já existe uma entidade com o nome: " + product.getNome());
    }
}