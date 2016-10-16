package jpatraining;

import jpatraining.domain.Collaborator;
import jpatraining.service.CollaboratorDao;
import jpatraining.service.CollaboratorDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class BootstrapDataLauncher {

    private CollaboratorDao collaboratorDao;

    public BootstrapDataLauncher(CollaboratorDao collaboratorDao) {
        this.collaboratorDao = collaboratorDao;
    }

    public void populate() {
        if (!databaseHasCollaborators()) {
            for (Collaborator collaborator : createCollaborators()) {
                collaboratorDao.save(collaborator);
            }
        }
    }

    private boolean databaseHasCollaborators() {
        return !collaboratorDao.findAll().isEmpty();
    }

    private List<Collaborator> createCollaborators() {
        Collaborator collaboratorGuillaume = new Collaborator("Guillaume", "Lincé", Date.valueOf("2013-10-01"));
        Collaborator collaboratorEtienne = new Collaborator("Etienne", "Martel", Date.valueOf("2013-10-01"));
        Collaborator collaboratorYannick = new Collaborator("Yannick", "Bruyninckx", Date.valueOf("2012-10-01"));
        Collaborator collaboratorGael = new Collaborator("Gaël", "Thouvenin", Date.valueOf("2015-11-11"));
        Collaborator collaboratorX = new Collaborator("X", "XxX", Date.valueOf("1990-10-01"));

        return Arrays.asList(collaboratorEtienne, collaboratorGael, collaboratorGuillaume, collaboratorX, collaboratorYannick);
    }


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hermesDataStore");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            CollaboratorDao collaboratorDao = new CollaboratorDaoImpl(em);
            new BootstrapDataLauncher(collaboratorDao).populate();

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
