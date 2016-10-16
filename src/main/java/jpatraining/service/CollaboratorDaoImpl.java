package jpatraining.service;

import jpatraining.domain.Collaborator;

import javax.persistence.EntityManager;
import java.util.List;

public class CollaboratorDaoImpl extends AbstractJpaDao<Collaborator, Long> implements CollaboratorDao {

    public CollaboratorDaoImpl(EntityManager entityManager) {
        super(entityManager, Collaborator.class);
    }

    @Override
    public List<Collaborator> findCollaboratorsWithFirstName(String firstName) {
        return getEntityManager().
                createQuery("select c from Collaborator c where c.firstName = :firstName", getEntityClass()).
                setParameter("firstName", firstName).
                getResultList();
    }
}
