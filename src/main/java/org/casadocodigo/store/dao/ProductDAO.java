package org.casadocodigo.store.dao;

import org.casadocodigo.store.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDAO {

    public void add(Product product) {
        entityManager.persist(product);
    }

    @PersistenceContext
    private EntityManager entityManager;
}
