package com.luizcasagrande.apipedido.pedido.pedidoItem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.luizcasagrande.apipedido.item.Item;
import com.luizcasagrande.apipedido.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItem {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @DecimalMin("0.01")
    @Column(nullable = false)
    private BigDecimal valorUnitario;

    @NotNull
    @DecimalMin("0.01")
    @Column(nullable = false)
    private BigDecimal quantidade;

    @NotNull
    @JoinColumn
    @ManyToOne(optional = false)
    private Item item;

    @JoinColumn
    @JsonBackReference
    @ManyToOne(optional = false)
    private Pedido pedido;
}
