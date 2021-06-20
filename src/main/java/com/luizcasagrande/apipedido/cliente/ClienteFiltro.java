package com.luizcasagrande.apipedido.cliente;

import lombok.Data;

@Data
public class ClienteFiltro {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
}
