package com.cmoiss.controleestoque.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class TestJPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "h2PU";
    private static EntityManagerFactory emf;

    public static EntityManager createTestEntityManager() {
        if (emf == null) {
            Map<String, String> properties = new HashMap<>();
            properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
            properties.put("javax.persistence.jdbc.user", "sa");
            properties.put("javax.persistence.jdbc.password", "");
            properties.put("hibernate.hbm2ddl.auto", "create-drop"); // Limpa o banco após cada teste
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
        }
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    public static void limparBanco(EntityManager em) {
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
}