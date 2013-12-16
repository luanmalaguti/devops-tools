package br.edu.ufpr.dao;

import br.edu.ufpr.bean.Bean;
import br.edu.ufpr.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;
import java.util.Objects;

/**
 * Create your specific DAO extending this class
 *
 * @author Luan Malaguti
 */
public class AbstractDAO<T extends Bean> implements DAO<T> {

    private final EntityManager em;
    private final Class<T> clazz;

    public AbstractDAO(Class<T> clazz) {
        this.em = PersistenceUtil.getInstance();
        this.clazz = clazz;
    }

    @Override
    public T save(T t) {
        em.getTransaction().begin();
        if(t.getId() != null){
            t = em.merge(t);
        }else{
            em.persist(t);
        }
        em.getTransaction().commit();
        return  t;
    }

    @Override
    public void delete(T t) {
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<T> list() {
        TypedQuery<T> q = em.createQuery("select e from " + clazz.getSimpleName() + " e", clazz);
        return q.getResultList();
    }

    @Override
    public T find(Long id) {
        return em.getReference(clazz, id);
    }
}