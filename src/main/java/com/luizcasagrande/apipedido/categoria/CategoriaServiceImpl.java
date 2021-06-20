package com.luizcasagrande.apipedido.categoria;

import com.luizcasagrande.apipedido.framework.CrudServiceImpl;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl extends CrudServiceImpl<Categoria, Long, CategoriaFiltro> implements CategoriaService {

    private final CategoriaRepository repository;

    @Override
    protected JpaRepository<Categoria, Long> getRepository() {
        return repository;
    }

    @Override
    public List<Categoria> filter(CategoriaFiltro filtro) {
        JPAQuery<Categoria> query = new JPAQuery<>(entityManager);
        QCategoria categoria = QCategoria.categoria;
        query.from(categoria);

        if (filtro.getId() != null) {
            query.where(categoria.id.eq(filtro.getId()));
        }
        if (filtro.getDescricao() != null) {
            query.where(categoria.descricao.containsIgnoreCase(filtro.getDescricao()));
        }
        return query.fetch();
    }
}
