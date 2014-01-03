package br.edu.ufpr.bean;

import java.io.Serializable;
/**
 * Interface a ser implementada pelos Beans persistíveis.
 */
public interface Bean extends Serializable {
    Long getId();
    void setId(Long id);
}

