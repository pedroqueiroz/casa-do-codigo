package org.casadocodigo.store.dao;

import org.casadocodigo.store.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Product product) {
        entityManager.persist(product);
    }

    public List<Product> list() {
        Query query =
                entityManager.createQuery("select p from Product p", Product.class);

        return query.getResultList();
    }

    public Product findById(Integer id) {
        return entityManager
            .createQuery(
                "select distinct(p) from Product p join fetch p.prices price where p.id = :id",
                Product.class)
            .setParameter("id", id)
            .getSingleResult();
    }
}
