package com.cmoiss.controleestoque.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2PU");
    public static final EntityManager em = emf.createEntityManager();;

    public static EntityManager createEntityManager() {
        return em;
    }

}
