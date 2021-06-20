package com.luizcasagrande.apipedido.cliente;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.luizcasagrande.apipedido.cliente.endereco.Endereco;
import com.luizcasagrande.apipedido.framework.annotation.CompleteField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @CompleteField
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @CPF
    @NotNull
    @Size(min = 11, max = 11)
    @Column(nullable = false, length = 11)
    private String cpf;

    @NotNull
    @Size(min = 10, max = 11)
    @Column(nullable = false, length = 11)
    private String telefone;

    @Valid
    @NotNull
    @JoinColumn
    @JsonManagedReference
    @OneToOne(optional = false, mappedBy = "cliente", cascade = CascadeType.ALL)
    private Endereco endereco;
}
