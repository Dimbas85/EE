package ru.nemtsov.persistance;

import ru.nemtsov.persistance.entity.Product;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;


@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProductRepository extends AbstractRepository<Product> implements Serializable {

    @Override
    public Product getById(long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Collection<Product> getAll() {
        // Пример использования Criteria API
        // Эквивалентен JPQL запросу entityManager.createQuery("select p from Product p").getResultList();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> from = query.from(Product.class);
        query.select(from);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public long count() {
        return (Long) entityManager.createQuery("select count(*) from Product p")
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public Collection<Product> getByCategory(long categoryId) {
        return entityManager.createQuery("select p from Product p where p.category.id = :id")
                .setParameter("id", categoryId)
                .getResultList();
    }
}
