package com.luizcasagrande.apipedido.item;

import com.luizcasagrande.apipedido.categoria.Categoria;
import lombok.Data;

@Data
public class ItemFiltro {

    private Long id;
    private String descricao;
    private Categoria categoria;
}
