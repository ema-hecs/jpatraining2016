package jpatraining.service;

import java.util.List;

public interface GenericDao<E,I> {

    E findOne(final I primaryKey);

    List<E> findAll();

    void save(final E entity);

    E update(final E entity);

    void delete(final E entity);

}