package br.edu.ufpr.dao;

import java.util.List;
/**
 * @param <T> Bean a ser persistido.
 */
public interface DAO<T> {

    /**
     * Salvar ou Atualizar um objeto Bean
     */
    T save(T t);

    /**
     * Remover um objeto Bean
     */
    void delete(T t);

    /**
     * Busca especifica de um objeto Bean por meio de um ID
     */
    T find(Long id);

    /**
     * Listagem de todos os objetos do tipo do Bean
     */
    List<T> list();
}


