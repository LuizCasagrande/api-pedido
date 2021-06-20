package com.luizcasagrande.apipedido.framework.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {

    private final String message;
    private final String path;
}
