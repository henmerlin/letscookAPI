/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.up.letscook.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author G0042204
 */
public abstract class AbstractHibernateDAO {

    private EntityManagerFactory emf;

    private EntityManager em;

    public void persist(Object obj) {
        try {
            getEm().getTransaction().begin();
            getEm().persist(obj);
            getEm().getTransaction().commit();
        } catch (Exception e) {
            getEm().getTransaction().rollback();
            throw e;
        }

    }

    public void remove(Object obj) {
        getEm().getTransaction().begin();
        getEm().remove(getEm().merge(obj));
        getEm().getTransaction().commit();
    }

    public void merge(Object obj) {
        getEm().getTransaction().begin();
        getEm().merge(obj);
        getEm().getTransaction().commit();
    }

    public EntityManager getEm() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("letscookAPIPU");
//            emf = Persistence.createEntityManagerFactory("letscookAPI_test");
            em = emf.createEntityManager();
        }
        return em;
    }

    public void close() {
        em.close();
        emf.close();
    }

}
