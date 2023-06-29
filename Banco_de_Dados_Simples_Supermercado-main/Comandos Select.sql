/* COMANDOS CLIENTE */
select *
from cliente
order by nome asc;

/* COMANDOS FUNCIONARIO */
select *
from funcionario
order by nome asc;

/* COMANDOS PEDIDO */
select pedido.valor as 'Valor Total', 
pedido.data as 'Data do Pedido',
cliente.nome as 'Nome do Cliente'
from pedido
inner join cliente on pedido.id_cliente = cliente.id
order by data asc;

/* COMANDOS CATEGORIA */
select categoria.id as 'Código da Categoria',
categoria.nome as 'Nome do Produto', 
funcionario.nome as 'Funcionário Responsável'
from categoria 
inner join funcionario on categoria.id_funcionario = funcionario.id
order by categoria.id;

/* COMANDOS PRODUTO */
select produto.nome as 'Nome do Produto',
produto.preco as 'Preço',
categoria.nome as 'Categoria do Produto',
funcionario.nome as'Funcionário Responsável'
from produto 
inner join categoria on produto.id_categoria = categoria.id
inner join funcionario on produto.id_funcionario = funcionario.id
order by produto.nome;

/* COMANDOS PRODUTO_PEDIDO */
select produto_pedido.quantidade as 'Quantidade de Produto',
produto.nome as 'Nome do Produto',
pedido.valor as 'Total do Pedido',
pedido.data as 'Data do Pedido'
from produto_pedido
inner join produto on produto_pedido.id_produto = produto.id
inner join pedido on produto_pedido.id_pedido = pedido.id
order by data asc;
