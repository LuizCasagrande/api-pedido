package com.luizcasagrande.apipedido.security.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    private String email;
    private String senha;
}
