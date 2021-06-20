package com.luizcasagrande.apipedido.widget.to;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VendaPorCliente {

    private String nome;
    private BigDecimal valor;
}
