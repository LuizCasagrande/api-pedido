package com.luizcasagrande.apipedido.widget;

import com.luizcasagrande.apipedido.widget.to.ItemMaisVendido;
import com.luizcasagrande.apipedido.widget.to.VendaPorCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WidgetServiceImpl implements WidgetService {

    private final WidgetData data;

    @Override
    public List<ItemMaisVendido> getItensMaisVendidos(LocalDate dataInicial) {
        return data.getItensMaisVendidos(dataInicial, dataInicial.with(TemporalAdjusters.lastDayOfMonth()));
    }

    @Override
    public List<VendaPorCliente> getVendasPorCliente(LocalDate dataInicial) {
        return data.getVendasPorCliente(dataInicial, dataInicial.with(TemporalAdjusters.lastDayOfMonth()));
    }
}
