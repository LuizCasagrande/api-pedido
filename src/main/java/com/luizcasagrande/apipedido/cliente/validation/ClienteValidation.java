package com.luizcasagrande.apipedido.cliente.validation;

import com.luizcasagrande.apipedido.cliente.Cliente;
import com.luizcasagrande.apipedido.cliente.ClienteService;
import com.luizcasagrande.apipedido.framework.exception.ExpectedException;

import java.util.function.BiConsumer;

public interface ClienteValidation extends BiConsumer<Cliente, ClienteService> {

    ClienteValidation validaDuplicidade = (cliente, service) -> {
        if (cliente.getId() == null && service.existsByCpf(cliente.getCpf())) {
            throw new ExpectedException("Registro duplicado");
        }
    };
}
