package com.cmoiss.controleestoque.dao;

import com.cmoiss.controleestoque.model.Categoria;
import com.cmoiss.controleestoque.util.TestJPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaDAOTest {
    private final EntityManager em = TestJPAUtil.createTestEntityManager();
    private final CategoriaDAO dao = new CategoriaDAO(this.em);

    @BeforeEach
    public void limparBanco() {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.createNativeQuery("DELETE FROM categorias").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Test
    void testaBuscaDeCategoriaPorNome() {
        String categoryName = "Teste de busca por nome";

        dao.cadastrar(new Categoria(categoryName));

        assertEquals(categoryName, dao.findByName(categoryName).getNome());
    }

    @Test
    void testaCadastroCategoria() {
        Categoria c = new Categoria("Teste de cadastro de categoria");

        dao.cadastrar(c);

        assertEquals(c.getNome(), dao.findByName(c.getNome()).getNome());
    }

    @Test
    void testaSeExcecaoEstaSendoLancadaAoInserirDuplicado() {
        Categoria c = new Categoria("Teste de exceção ao inserir duplicado");

        dao.cadastrar(c);

        assertThrows(IllegalArgumentException.class, () -> dao.cadastrar(c));
    }

    @Test
    void testaBuscaPorTodasCategorias() {
        Categoria c1 = new Categoria("Bebida");
        Categoria c2 = new Categoria("Refrigerante");
        Categoria c3 = new Categoria("Energético");
        Categoria c4 = new Categoria("Vinho");
        List<Categoria> categoriasListCurrent = Arrays.asList(
            c1, c2, c3, c4
        );

        dao.cadastrar(c1);
        dao.cadastrar(c2);
        dao.cadastrar(c3);
        dao.cadastrar(c4);

        List<Categoria> categoriasFromDatabase = dao.fetchAll();

        assertThat(categoriasFromDatabase)
                .hasSameSizeAs(categoriasListCurrent)
                .containsExactlyInAnyOrderElementsOf(categoriasListCurrent);
    }
}