package br.edu.ufpr.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    protected static EntityManagerFactory emf = null;
    protected static EntityManager em = null;

    private PersistenceUtil() {
        emf = Persistence.createEntityManagerFactory("persistence-base");
        em = emf.createEntityManager();
    }

    public static EntityManager getInstance(){
        if(em == null){
            new PersistenceUtil();
        }
        return em;
    }

}