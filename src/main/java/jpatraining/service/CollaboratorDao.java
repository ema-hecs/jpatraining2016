package jpatraining.service;

import jpatraining.domain.Collaborator;

import java.util.List;

public interface CollaboratorDao extends GenericDao<Collaborator, Long> {

    List<Collaborator> findCollaboratorsWithFirstName(String firstName);
}
