package com.cmoiss.controleestoque.service.strategy;

import com.cmoiss.controleestoque.model.Entidade;

public interface ValidacaoStrategy <T extends Entidade> {
    void validar(T entity);
}
