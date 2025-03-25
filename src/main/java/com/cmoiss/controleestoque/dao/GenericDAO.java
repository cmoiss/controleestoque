package com.cmoiss.controleestoque.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class GenericDAO <T, ID> {
    private Class<T> classe;
    private EntityManager em;

    public GenericDAO(Class<T> classe, EntityManager em) {
        this.classe = classe;
        this.em = em;
    }

    private GenericDAO<T, ID> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    private GenericDAO<T, ID> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    private GenericDAO<T, ID> salvar(T entity) {
        em.persist(entity);
        return this;
    }

    public void cadastrar(T entity) {
        // Verifica se a entidade já existe no banco de dados
        if (em.contains(entity)) {
            throw new IllegalArgumentException("A entidade já existe no banco de dados");
        }

        abrirTransacao().salvar(entity).fecharTransacao();
    }

    public T findByName(String name) {
        return em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e WHERE e.nome = :name", classe)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<T> fetchAll() {
        return em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e", classe).getResultList();
    }
}
