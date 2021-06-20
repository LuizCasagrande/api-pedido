package com.luizcasagrande.apipedido.categoria;

import com.luizcasagrande.apipedido.framework.CrudRestController;
import com.luizcasagrande.apipedido.framework.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
@RequiredArgsConstructor
public class CategoriaController extends CrudRestController<Categoria, Long, CategoriaFiltro> {

    private final CategoriaService service;

    @Override
    protected CrudService<Categoria, Long, CategoriaFiltro> getService() {
        return service;
    }
}
