package com.luizcasagrande.apipedido.item;

import com.luizcasagrande.apipedido.framework.CrudServiceImpl;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl extends CrudServiceImpl<Item, Long, ItemFiltro> implements ItemService {

    private final ItemRepository repository;

    @Override
    protected JpaRepository<Item, Long> getRepository() {
        return repository;
    }

    @Override
    public List<Item> filter(ItemFiltro filtro) {
        JPAQuery<Item> query = new JPAQuery<>(entityManager);
        QItem item = QItem.item;
        query.from(item);

        if (filtro.getId() != null) {
            query.where(item.id.eq(filtro.getId()));
        }
        if (filtro.getDescricao() != null) {
            query.where(item.descricao.containsIgnoreCase(filtro.getDescricao()));
        }
        if (filtro.getCategoria() != null) {
            query.where(item.categoria.id.eq(filtro.getCategoria().getId()));
        }
        return query.fetch();
    }
}
