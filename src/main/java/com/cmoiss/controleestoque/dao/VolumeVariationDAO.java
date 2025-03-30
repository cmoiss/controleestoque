package com.cmoiss.controleestoque.dao;

import com.cmoiss.controleestoque.model.Product;
import com.cmoiss.controleestoque.model.VolumeVariation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class VolumeVariationDAO extends GenericDAO<VolumeVariation, Long> {
    public VolumeVariationDAO(EntityManager entityManager) {
        super(VolumeVariation.class, entityManager);
    }

    public List<VolumeVariation> findByProduct(Product product) {
        try {
            TypedQuery<VolumeVariation> query = entityManager.createQuery(
                    "SELECT v FROM VolumeVariation v WHERE v.product = :product",
                    VolumeVariation.class
            );
            query.setParameter("product", product);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao buscar variações por produto", e);
        }
    }

    public VolumeVariation findByProductAndVolume(Product product, Integer volumeValue) {
        try {
            TypedQuery<VolumeVariation> query = entityManager.createQuery(
                    "SELECT v FROM VolumeVariation v WHERE v.product = :product AND v.volumeValue = :volumeValue",
                    VolumeVariation.class
            );
            query.setParameter("product", product);
            query.setParameter("volumeValue", volumeValue);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao buscar variação por produto e volume", e);
        }
    }
}
