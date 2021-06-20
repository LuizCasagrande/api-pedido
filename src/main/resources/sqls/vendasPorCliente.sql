select
    c.nome as nome,
    sum(p.valor_total) as valor
from
    cliente c
inner join pedido p on
    p.cliente_id = c.id
where
    p.data_cadastro between '${dataInicial}' and '${dataFinal}'
group by
    c.nome
limit 5
