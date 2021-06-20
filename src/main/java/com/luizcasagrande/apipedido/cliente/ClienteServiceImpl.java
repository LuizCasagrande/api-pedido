package com.luizcasagrande.apipedido.cliente;

import com.luizcasagrande.apipedido.cliente.validation.ClienteValidation;
import com.luizcasagrande.apipedido.framework.CrudServiceImpl;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl extends CrudServiceImpl<Cliente, Long, ClienteFiltro> implements ClienteService {

    private final ClienteRepository repository;

    @Override
    protected JpaRepository<Cliente, Long> getRepository() {
        return repository;
    }

    @Override
    public Boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }

    @Override
    public void preSave(Cliente entity) {
        ClienteValidation.validaDuplicidade.accept(entity, this);
    }

    @Override
    public List<Cliente> filter(ClienteFiltro filtro) {
        JPAQuery<Cliente> query = new JPAQuery<>(entityManager);
        QCliente cliente = QCliente.cliente;
        query.from(cliente);

        if (filtro.getId() != null) {
            query.where(cliente.id.eq(filtro.getId()));
        }
        if (filtro.getNome() != null) {
            query.where(cliente.nome.containsIgnoreCase(filtro.getNome()));
        }
        if (filtro.getCpf() != null) {
            query.where(cliente.cpf.containsIgnoreCase(filtro.getCpf()));
        }
        if (filtro.getTelefone() != null) {
            query.where(cliente.telefone.containsIgnoreCase(filtro.getTelefone()));
        }
        return query.fetch();
    }
}
