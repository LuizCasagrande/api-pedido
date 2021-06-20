package com.luizcasagrande.apipedido.widget;

import com.luizcasagrande.apipedido.widget.to.ItemMaisVendido;
import com.luizcasagrande.apipedido.widget.to.VendaPorCliente;

import java.time.LocalDate;
import java.util.List;

public interface WidgetService {

    List<ItemMaisVendido> getItensMaisVendidos(LocalDate dataInicial);

    List<VendaPorCliente> getVendasPorCliente(LocalDate dataInicial);
}
