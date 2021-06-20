package com.luizcasagrande.apipedido.pedido;

import com.luizcasagrande.apipedido.framework.CrudServiceImpl;
import com.luizcasagrande.apipedido.util.CollectionUtil;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl extends CrudServiceImpl<Pedido, Long, PedidoFiltro> implements PedidoService {

    private final PedidoRepository repository;

    @Override
    protected JpaRepository<Pedido, Long> getRepository() {
        return repository;
    }

    @Override
    public void preSave(Pedido entity) {
        calculaTotal(entity);
    }

    private void calculaTotal(Pedido entity) {
        entity.setValorTotal(
                entity.getItens().stream()
                        .map(e -> e.getQuantidade().multiply(e.getValorUnitario()))
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @Override
    public void postFindOne(Pedido entity) {
        CollectionUtil.lazyLoad(entity.getItens());
    }

    @Override
    public List<Pedido> filter(PedidoFiltro filtro) {
        JPAQuery<Pedido> query = new JPAQuery<>(entityManager);
        QPedido pedido = QPedido.pedido;
        query.from(pedido);

        if (filtro.getId() != null) {
            query.where(pedido.id.eq(filtro.getId()));
        }
        if (filtro.getDataCadastroInicial() != null) {
            query.where(pedido.dataCadastro.goe(filtro.getDataCadastroInicial()));
        }
        if (filtro.getDataCadastroFinal() != null) {
            query.where(pedido.dataCadastro.loe(filtro.getDataCadastroFinal()));
        }
        if (filtro.getCliente() != null) {
            query.where(pedido.cliente.id.eq(filtro.getCliente().getId()));
        }
        return query.fetch();
    }
}
