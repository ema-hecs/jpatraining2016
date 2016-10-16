package jpatraining.service;

import javax.persistence.EntityManager;
import java.util.List;

import static java.util.Objects.requireNonNull;

abstract class AbstractJpaDao<E, I> implements GenericDao<E, I> {

    private static final String ENTITY_MANAGER_NOT_NULL = "entityManager must not be null.";
    private static final String ENTITY_CLASS_NOT_NULL = "entityClass must not be null.";

    private EntityManager entityManager;

    private Class<E> entityClass;

    public AbstractJpaDao(EntityManager entityManager, Class<E> entityClass) {
        requireNonNull(entityManager, ENTITY_MANAGER_NOT_NULL);
        requireNonNull(entityClass, ENTITY_CLASS_NOT_NULL);

        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public E findOne(I primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    @Override
    public List<E> findAll() {
        return entityManager.
                createQuery("from "+ entityClass.getName(), entityClass).
                getResultList();
    }

    @Override
    public void save(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public E update(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(E entity) {
        entityManager.remove(entity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }
}
