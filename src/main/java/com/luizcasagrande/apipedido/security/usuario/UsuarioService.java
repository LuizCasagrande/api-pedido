package com.luizcasagrande.apipedido.security.usuario;

import com.luizcasagrande.apipedido.framework.CrudService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends CrudService<Usuario, Long, Void>, UserDetailsService {
}
