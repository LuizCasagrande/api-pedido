package com.luizcasagrande.apipedido.item;

import com.luizcasagrande.apipedido.framework.CrudRestController;
import com.luizcasagrande.apipedido.framework.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
@RequiredArgsConstructor
public class ItemController extends CrudRestController<Item, Long, ItemFiltro> {

    private final ItemService service;

    @Override
    protected CrudService<Item, Long, ItemFiltro> getService() {
        return service;
    }
}
