package com.luizcasagrande.apipedido.cliente.endereco;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.luizcasagrande.apipedido.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String numero;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String descricao;

    @NotNull
    @Size(min = 8, max = 8)
    @Column(nullable = false, length = 8)
    private String cep;

    @JoinColumn
    @JsonBackReference
    @OneToOne(optional = false)
    private Cliente cliente;
}
