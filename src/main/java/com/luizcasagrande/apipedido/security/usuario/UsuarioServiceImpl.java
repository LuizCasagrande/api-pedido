package com.luizcasagrande.apipedido.security.usuario;

import com.luizcasagrande.apipedido.framework.CrudServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario, Long, Void> implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    protected JpaRepository<Usuario, Long> getRepository() {
        return repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    }
}
