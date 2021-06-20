package com.luizcasagrande.apipedido.widget;

import com.luizcasagrande.apipedido.util.SqlUtil;
import com.luizcasagrande.apipedido.widget.to.ItemMaisVendido;
import com.luizcasagrande.apipedido.widget.to.VendaPorCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WidgetData {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final String SQL_ITENS_MAIS_VENDIDOS = SqlUtil.getSqlFile("sqls/itensMaisVendidos.sql");
    private final String SQL_VENDAS_POR_CLIENTE = SqlUtil.getSqlFile("sqls/vendasPorCliente.sql");

    public List<ItemMaisVendido> getItensMaisVendidos(LocalDate dataInicial, LocalDate dataFinal) {
        String sql = SQL_ITENS_MAIS_VENDIDOS
                .replace("${dataInicial}", dataInicial.toString())
                .replace("${dataFinal}", dataFinal.toString());

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ItemMaisVendido.class));
    }

    public List<VendaPorCliente> getVendasPorCliente(LocalDate dataInicial, LocalDate dataFinal) {
        String sql = SQL_VENDAS_POR_CLIENTE
                .replace("${dataInicial}", dataInicial.toString())
                .replace("${dataFinal}", dataFinal.toString());

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VendaPorCliente.class));
    }
}
