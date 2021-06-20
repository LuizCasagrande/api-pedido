package com.luizcasagrande.apipedido.pedido;

import com.luizcasagrande.apipedido.framework.CrudRestController;
import com.luizcasagrande.apipedido.framework.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
@RequiredArgsConstructor
public class PedidoController extends CrudRestController<Pedido, Long, PedidoFiltro> {

    private final PedidoService service;

    @Override
    protected CrudService<Pedido, Long, PedidoFiltro> getService() {
        return service;
    }
}
