package com.cmoiss.controleestoque.service;

import com.cmoiss.controleestoque.model.Categoria;
import com.cmoiss.controleestoque.util.TestJPAUtil;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class CategoriaServiceTest {
    private final EntityManager em = TestJPAUtil.createTestEntityManager();
    private final CategoriaService service = new CategoriaService(em);

    @BeforeEach
    public void limparBanco() {
        TestJPAUtil.limparBanco(this.em);
    }

    @Test
    void testaCadastroCategoria() {
        Categoria c = new Categoria("Teste de cadastro de categoria");

        service.save(c);

        assertEquals(c.getNome(), service.findByName(c.getNome()).getNome());
    }

    @Test
    void testaSeExcecaoEstaSendoLancadaAoInserirDuplicado() {
        Categoria c = new Categoria("Teste de exceção ao inserir duplicado");

        service.save(c);

        assertThrows(EntityExistsException.class, () -> service.save(c));
    }

    @Test
    void testaBuscaDeCategoriaPorNome() {
        String categoryName = "Teste de busca por nome";

        service.save(new Categoria(categoryName));

        assertEquals(categoryName, service.findByName(categoryName).getNome());
    }

    @Test
    void testaBuscaPorTodasCategorias() {
        Categoria c1 = new Categoria("Bebida");
        Categoria c2 = new Categoria("Refrigerante");
        Categoria c3 = new Categoria("Energético");
        Categoria c4 = new Categoria("Vinho");
        List<Categoria> categoriasListCurrent = Arrays.asList(c1, c2, c3, c4);

        service.save(c1);
        service.save(c2);
        service.save(c3);
        service.save(c4);

        List<Categoria> categoriasFromDatabase = service.findAll();

        assertThat(categoriasFromDatabase)
                .hasSameSizeAs(categoriasListCurrent)
                .containsExactlyInAnyOrderElementsOf(categoriasListCurrent);
    }

    @Test
    void testaAtualizacaoCategoria() {
        Categoria c = new Categoria("Categoria Original");
        service.save(c);

        c.setNome("Categoria Atualizada");
        service.update(c);

        assertEquals("Categoria Atualizada", service.findById(c.getId()).getNome());
    }

    @Test
    void testaExclusaoCategoria() {
        Categoria c = new Categoria("Categoria a ser excluída");
        service.save(c);

        service.delete(c.getId());

        assertNull(service.findById(c.getId()));
    }

    @Test
    void testaBuscaCategoriaPorId() {
        Categoria c = new Categoria("Categoria por ID");
        service.save(c);

        Categoria encontrada = service.findById(c.getId());

        assertNotNull(encontrada);
        assertEquals(c.getId(), encontrada.getId());
    }
}
