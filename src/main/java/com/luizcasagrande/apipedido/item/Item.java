package com.luizcasagrande.apipedido.item;

import com.luizcasagrande.apipedido.categoria.Categoria;
import com.luizcasagrande.apipedido.framework.annotation.CompleteField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @CompleteField
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String descricao;

    @NotNull
    @DecimalMin("0.01")
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull
    @JoinColumn
    @ManyToOne(optional = false)
    private Categoria categoria;
}
