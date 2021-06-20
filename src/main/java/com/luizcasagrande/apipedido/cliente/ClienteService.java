package com.luizcasagrande.apipedido.cliente;

import com.luizcasagrande.apipedido.framework.CrudService;

public interface ClienteService extends CrudService<Cliente, Long, ClienteFiltro> {

    Boolean existsByCpf(String cpf);
}
