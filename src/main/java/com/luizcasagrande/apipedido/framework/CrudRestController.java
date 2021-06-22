package com.luizcasagrande.apipedido.framework;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudRestController<T, ID, Y> {

    protected abstract CrudService<T, ID, Y> getService();

    @PreAuthorize("hasAuthority('ROLE_PESQUISAR')")
    @Transactional(readOnly = true)
    @GetMapping
    public List<T> findAll() {
        return getService().findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_PESQUISAR')")
    @Transactional(readOnly = true)
    @GetMapping("page")
    public Page<T> findAll(Pageable pageable) {
        return getService().findAll(pageable);
    }

    @PreAuthorize("hasAuthority('ROLE_PESQUISAR')")
    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public T findOne(@PathVariable("id") ID id) {
        return getService().findOne(id);
    }

    @PreAuthorize("hasAuthority('ROLE_CADASTRAR')")
    @Transactional(rollbackFor = Exception.class)
    @PostMapping
    public T save(@RequestBody T entity) {
        return getService().save(entity);
    }

    @PreAuthorize("hasAuthority('ROLE_REMOVER')")
    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ID id) {
        getService().delete(id);
    }

    @PreAuthorize("hasAuthority('ROLE_PESQUISAR')")
    @Transactional(readOnly = true)
    @GetMapping("complete")
    public List<T> complete(@RequestParam("query") String query) {
        return getService().complete(query);
    }

    @PreAuthorize("hasAuthority('ROLE_PESQUISAR')")
    @Transactional(readOnly = true)
    @PostMapping("filter")
    public List<T> filter(@RequestBody Y filtro) {
        return getService().filter(filtro);
    }
}
