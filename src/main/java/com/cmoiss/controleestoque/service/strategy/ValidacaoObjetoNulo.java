package com.cmoiss.controleestoque.service.strategy;

import com.cmoiss.controleestoque.model.Entidade;

public class ValidacaoObjetoNulo <T extends Entidade> implements ValidacaoStrategy<T> {
    @Override
    public void validar(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
    }
}