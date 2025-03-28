package com.cmoiss.controleestoque.service.strategy;

import com.cmoiss.controleestoque.model.Entidade;
import com.cmoiss.controleestoque.model.EntidadeNomeada;

public class ValidacaoNomeObrigatorio <T extends EntidadeNomeada> implements ValidacaoStrategy<T> {
    @Override
    public void validar(T entity) {
        if (entity.getNome() == null || entity.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da entidade é obrigatória.");
        }
    }
}