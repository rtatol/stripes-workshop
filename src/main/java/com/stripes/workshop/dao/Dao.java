package com.stripes.workshop.dao;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author raf
 */
public class Dao {

    private static final String PERSISTENCE_UNIT_NAME = "com.stripes.workshop.PU";

    private static final Logger logger = Logger.getLogger(Dao.class.getSimpleName());
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    protected EntityManager entityManager;

    public Dao() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public List getAll(Class clazz) {
        return entityManager.createQuery("SELECT o FROM " + clazz.getSimpleName() + " o").getResultList();
    }

    public <T, ID> T get(Class<T> clazz, ID id) {
        return entityManager.find(clazz, id);
    }

    public <T> void create(T object) {
        entityManager.persist(object);
    }

    public <T> T update(T object) {
        return entityManager.merge(object);
    }

    public <T> void delete(T object) {
        entityManager.remove(object);
    }

    public <T> List<T> find(Class<T> clazz, String namedQuery, Object... params) {
        Query query = clazz == null ? entityManager.createNamedQuery(namedQuery) : entityManager.createNamedQuery(namedQuery, clazz);
        // TODO fill named query parameters
        return query.getResultList();
    }

    public void commit() {
        entityManager.getTransaction().commit();
    }

    public void flush() {
        entityManager.flush();
    }

}
