package com.luizcasagrande.apipedido.widget;

import com.luizcasagrande.apipedido.widget.to.ItemMaisVendido;
import com.luizcasagrande.apipedido.widget.to.VendaPorCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("widget")
@RequiredArgsConstructor
public class WidgetController {

    private final WidgetService service;

    @GetMapping("itens-mais-vendidos")
    public List<ItemMaisVendido> getItensMaisVendidos(@RequestParam("dataInicial") LocalDate dataInicial) {
        return service.getItensMaisVendidos(dataInicial);
    }

    @GetMapping("vendas-por-cliente")
    public List<VendaPorCliente> getVendasPorCliente(@RequestParam("dataInicial") LocalDate dataInicial) {
        return service.getVendasPorCliente(dataInicial);
    }
}
