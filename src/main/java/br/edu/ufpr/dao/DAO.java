package br.edu.ufpr.dao;

import java.util.List;

/**
 * Create your custom DAO interfaces extending this one.
 *
 * @author Luan Malaguti
 *
 * @param <T> Bean
 */
public interface DAO<T> {

    T save(T t);

    void delete(T t);

    List<T> list();

    T find(Long id);
}
