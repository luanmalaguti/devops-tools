package br.edu.ufpr.dao;

import br.edu.ufpr.bean.Bean;
import br.edu.ufpr.util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * DAO genérico com a implementação padrão para métodos providos pela
 * Interface DAO<T>.
 *
 * @param <T> Bean a ser persistido.
 */
public class GenericDAO<T extends Bean> implements DAO<T> {

    private final EntityManager em;
    private final Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
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
    }

    @Override
    public List<T> list() {
        Query q = em.createNamedQuery("User.list");
        return q.getResultList();
    }

    @Override
    public T find(Long id) {
        try {
            return em.getReference(clazz, id);
        }catch (EntityNotFoundException e){
            return null;
        }

    }
}

