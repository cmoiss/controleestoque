package com.cmoiss.controleestoque.service;

import com.cmoiss.controleestoque.dao.CategoriaDAO;
import com.cmoiss.controleestoque.model.Categoria;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaService {

    private final CategoriaDAO dao;

    public CategoriaService(EntityManager em) {
        this.dao = new CategoriaDAO(em);
    }

    // ---- Métodos CRUD com validações e tratamento de exceções ---- //

    public Categoria save(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula.");
        }

        if (categoria.getNome() == null || categoria.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria é obrigatório.");
        }

        // Verifica se categoria já existe (evita duplicação)
        if (dao.findByName(categoria.getNome()) != null) {
            throw new EntityExistsException("Já existe uma categoria com o nome: " + categoria.getNome());
        }

        try {
            return dao.save(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao salvar categoria: " + categoria.getNome(), e);
        }
    }

    public Categoria update(Categoria categoria) {
        if (categoria == null || categoria.getId() == null) {
            throw new IllegalArgumentException("Categoria ou ID inválido para atualização.");
        }

        // Verifica se a categoria existe no banco
        Categoria existente = dao.findById(categoria.getId());
        if (existente == null) {
            throw new IllegalStateException("Categoria não encontrada para atualização (ID: " + categoria.getId() + ")");
        }

        try {
            return dao.update(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao atualizar categoria (ID: " + categoria.getId() + ")", e);
        }
    }

    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da categoria não pode ser nulo.");
        }

        try {
            dao.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao remover categoria (ID: " + id + ")", e);
        }
    }

    public Categoria findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da categoria não pode ser nulo.");
        }

        try {
            return dao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao buscar categoria por ID: " + id, e);
        }
    }

    public Categoria findByName(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria não pode ser vazio.");
        }

        try {
            return dao.findByName(nome);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao buscar categoria por nome: " + nome, e);
        }
    }

    public List<Categoria> findAll() {
        try {
            return dao.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao listar categorias.", e);
        }
    }
}