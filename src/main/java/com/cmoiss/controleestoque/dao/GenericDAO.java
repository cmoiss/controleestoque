package com.cmoiss.controleestoque.dao;

import com.cmoiss.controleestoque.model.EntidadeNomeada;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public abstract class GenericDAO<T, ID> {

    private final Class<T> entityClass;
    protected EntityManager entityManager;

    public GenericDAO(Class<T> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    public T findById(ID id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao buscar entidade por ID: " + id, e);
        }
    }

    public T findByName(String nome) {
        if (!EntidadeNomeada.class.isAssignableFrom(entityClass)) {
            throw new UnsupportedOperationException(
                    "Esta entidade não suporta busca por nome (não estende EntidadeNomeada)."
            );
        }

        try {
            TypedQuery<T> query = entityManager.createQuery(
                    "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.nome = :nome",
                    entityClass
            );
            query.setParameter("nome", nome);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao buscar entidade por nome: " + nome, e);
        }
    }

    public List<T> findAll() {
        try {
            return entityManager.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao listar todas as entidades", e);
        }
    }

    public T save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Falha ao salvar entidade", e);
        }
    }

    public T update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            T updatedEntity = entityManager.merge(entity);
            transaction.commit();
            return updatedEntity;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Falha ao atualizar entidade", e);
        }
    }

    public void delete(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Falha ao remover entidade", e);
        }
    }

    public void deleteById(ID id) {
        try {
            T entity = findById(id);
            if (entity != null) {
                delete(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao remover entidade por ID: " + id, e);
        }
    }
}