select
    i.descricao as descricao,
    sum(pi.quantidade) as quantidade
from
    item i
inner join pedido_item pi on
    pi.item_id = i.id
inner join pedido p on
    p.id = pi.pedido_id
where
    p.data_cadastro between '${dataInicial}' and '${dataFinal}'
group by
    i.descricao
limit 5
