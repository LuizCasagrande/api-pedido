package com.luizcasagrande.apipedido.widget.to;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemMaisVendido {

    private String descricao;
    private BigDecimal quantidade;
}
