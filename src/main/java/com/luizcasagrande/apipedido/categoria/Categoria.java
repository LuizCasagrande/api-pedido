package com.luizcasagrande.apipedido.categoria;

import com.luizcasagrande.apipedido.framework.annotation.CompleteField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @CompleteField
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String descricao;
}
