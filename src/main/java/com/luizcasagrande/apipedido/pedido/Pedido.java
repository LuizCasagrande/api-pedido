package com.luizcasagrande.apipedido.pedido;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.luizcasagrande.apipedido.cliente.Cliente;
import com.luizcasagrande.apipedido.pedido.pedidoItem.PedidoItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataCadastro;

    @NotNull
    @JoinColumn
    @ManyToOne(optional = false)
    private Cliente cliente;

    @Column(nullable = false, scale = 2)
    private BigDecimal valorTotal;

    @Valid
    @Size(min = 1, max = 5)
    @JsonManagedReference
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoItem> itens = new ArrayList<>();
}
