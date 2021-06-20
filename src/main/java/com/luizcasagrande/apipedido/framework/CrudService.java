package com.luizcasagrande.apipedido.framework;

import com.luizcasagrande.apipedido.framework.exception.ExpectedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudService<T, ID, Y> {

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    T findOne(ID id);

    T save(T entity);

    void delete(ID id);

    List<T> complete(String query);

    default List<T> filter(Y filtro) {
        throw new ExpectedException("não implementado");
    }
}
