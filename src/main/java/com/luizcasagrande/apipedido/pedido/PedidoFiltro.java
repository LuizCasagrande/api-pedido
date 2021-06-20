package com.luizcasagrande.apipedido.pedido;

import com.luizcasagrande.apipedido.cliente.Cliente;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoFiltro {

    private Long id;
    private LocalDate dataCadastroInicial;
    private LocalDate dataCadastroFinal;
    private Cliente cliente;
}
