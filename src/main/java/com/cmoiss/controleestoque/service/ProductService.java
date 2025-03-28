package com.cmoiss.controleestoque.service;

import com.cmoiss.controleestoque.dao.ProductDAO;
import com.cmoiss.controleestoque.model.Product;
import com.cmoiss.controleestoque.service.strategy.ValidacaoNomeObrigatorio;
import com.cmoiss.controleestoque.service.strategy.ValidacaoObjetoExiste;
import com.cmoiss.controleestoque.service.strategy.ValidacaoObjetoNulo;
import com.cmoiss.controleestoque.service.strategy.ValidacaoStrategy;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.cmoiss.controleestoque.service.TipoValidacao.OBJETO_NULO;

enum TipoValidacao {
    OBJETO_NULO,
    NOME_OBRIGATORIO,
    OBJETO_EXISTENTE
}

public class ProductService {
    private final ProductDAO dao;

    private final List<ValidacaoStrategy<Product>> validacoes = new ArrayList<>();
    private final Map<TipoValidacao, ValidacaoStrategy<?>> validacoesMap;

    public ProductService(EntityManager em) {
        this.dao = new ProductDAO(em);

        this.validacoes.addAll(List.of(
                new ValidacaoObjetoNulo<>(),
                new ValidacaoNomeObrigatorio<>(),
                new ValidacaoObjetoExiste<>(dao)
        ));


        this.validacoesMap = Map.of(
                OBJETO_NULO, new ValidacaoObjetoNulo<>(),
                TipoValidacao.NOME_OBRIGATORIO, new ValidacaoNomeObrigatorio<>(),
                TipoValidacao.OBJETO_EXISTENTE, new ValidacaoObjetoExiste<>(dao)
        );
    }

    private void executarValidacoes(Product product) {
        for (ValidacaoStrategy<Product> validacao : validacoes) {
            validacao.validar(product);
        }
    }

    public Product save(Product product) {
        executarValidacoes(product);

        try {
            return dao.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao salvar categoria: " + product.getNome(), e);
        }
    }

    public Product findByName(String name) {
        if (name == null || name.isBlank()) throw new NullPointerException();

        return dao.findByName(name);
    }
}
