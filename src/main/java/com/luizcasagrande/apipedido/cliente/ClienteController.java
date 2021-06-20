package com.luizcasagrande.apipedido.cliente;

import com.luizcasagrande.apipedido.framework.CrudRestController;
import com.luizcasagrande.apipedido.framework.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
@RequiredArgsConstructor
public class ClienteController extends CrudRestController<Cliente, Long, ClienteFiltro> {

    private final ClienteService service;

    @Override
    protected CrudService<Cliente, Long, ClienteFiltro> getService() {
        return service;
    }
}
