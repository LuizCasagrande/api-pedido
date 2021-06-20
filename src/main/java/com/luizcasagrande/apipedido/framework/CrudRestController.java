package com.luizcasagrande.apipedido.framework;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudRestController<T, ID, Y> {

    protected abstract CrudService<T, ID, Y> getService();

    @Transactional(readOnly = true)
    @GetMapping
    public List<T> findAll() {
        return getService().findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("page")
    public Page<T> findAll(Pageable pageable) {
        return getService().findAll(pageable);
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public T findOne(@PathVariable("id") ID id) {
        return getService().findOne(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping
    public T save(@RequestBody T entity) {
        return getService().save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ID id) {
        getService().delete(id);
    }

    @Transactional(readOnly = true)
    @GetMapping("complete")
    public List<T> complete(@RequestParam("query") String query) {
        return getService().complete(query);
    }

    @Transactional(readOnly = true)
    @PostMapping("filter")
    public List<T> filter(@RequestBody Y filtro) {
        return getService().filter(filtro);
    }
}
