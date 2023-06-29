Esse Arquivo serve para caso der problema nos arquivos
.sql este seria um tipo de backup.


Ordem da Criação:

1- Database
2- use Database
3- table Cliente
4- table Pedido
5- table funcionario
6- table categoria
7- table produto
8- table produto_pedido

-----------------------------------------------------------------------

/*Criando Banco de dados e suas tabelas*/

create database Supermercado_A3;
use Supermercado_A3;

create table `cliente` (
`id` int primary key not null auto_increment,
`nome` varchar(100) not null,
`email` varchar(100) not null unique,
`senha` varchar(50) not null,
`cpf` varchar(11) not null unique,
`telefone` varchar(15) not null,
`rua` varchar(100) not null,
`bairro` varchar(100) not null,
`cidade` varchar(100) not null,
`cep` varchar(8) not null,
`saldo` float not null
);

create table `pedido`(
`id` int primary key not null auto_increment,
`valor` float not null,
`data` datetime not null,
`id_cliente` int,
foreign key (`id_cliente`) references `cliente`(`id`)
);

create table `funcionario` (
`id` int primary key not null auto_increment,
`nome` varchar(100) not null,
`email` varchar(100) not null unique,
`senha` varchar(50) not null,
`cpf` varchar(11) not null unique,
`telefone` varchar(15) not null,
`rua` varchar(100) not null,
`bairro` varchar(100) not null,
`cidade` varchar(100) not null,
`cep` varchar(8) not null,
`salario` float not null
);

create table `categoria`(
`id` int primary key not null auto_increment,
`nome` varchar(45) not null unique,
`id_funcionario` int,
foreign key (`id_funcionario`) references `funcionario`(`id`) 
);

create table `produto`(
`id` int primary key not null auto_increment,
`nome` varchar(100) not null,
`preco` float not null,
`quantidade_estoque` int not null,
`id_categoria` int,
`id_funcionario` int,
foreign key (`id_categoria`) references `categoria`(id),
foreign key (`id_funcionario`) references `funcionario`(id)
);

create table `produto_pedido`(
`quantidade` int not null,
`id_produto` int,
`id_pedido` int,
foreign key (`id_produto`) references `produto`(`id`),
foreign key (`id_pedido`) references `pedido`(`id`)
);



________________________________________________________________________


/*Populando Banco de dados e suas tabelas*/

insert into cliente (nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, saldo)
values
('Marcio Mama Mia', 'grelhadosmarcio@gmail.com', '1234', '11111111111', '551140028922', 'Av. Judas Presunto', 'Isopor Quadrado', 'Porto Triste', '99999999','10000.00'),
('Flavio churrasco sandreli', 'modelagemepr@outlook.com', '1234', '11111111112', '551140028921', 'Av. Judas Presunto', 'Isopor Quadrado','Porto Triste', '99999999', '15000.00'),
('Deivid Beckhan', 'deivid56@gmail.com', '1234', '11111111113', '551140028920', 'Rua Tomais Feliz', 'Doutor Piolho', 'Cabra Mansa', '99999787', '5000.00'),
('Adalto Silva Junior', 'palestra@gmail.com', '1234', '11111111114', '551140028923', 'Rua Sofredor da TI', 'Doutor Piolho', 'Cabra Mansa', '99999786', '20000.00'),
('Robson Fazendo Forum', 'forunista@outlook.com', '1234', '11111111115', '551140028924', 'eu fiz', 'o forum', 'em modelagem', '99999675', '1200.00'),
('Eva Dias', 'evaia@gmail.com', '1234', '11111111116', '551140028925', 'Av. Juca Batida', 'o forum', 'em modelagem', '99999673', '10000000.00'),
('Luan aesquina', 'refletor@gmail.com', '1234', '11111111117', '551140028926', 'av. correnteza', 'paralização', 'feriados', '99999563','20000.00'),
('Francisco Melo', 'drfrandenicol@outlook.com', '1234', '11111111118', '551140028927', 'rua são sebastião', 'paralização', 'feriados', '99999562', '3000.00'),
('Déssio Pinto', 'dessiodoido@gmail.com', '1234', '11111111119', '551140028928', 'av. senador gonçalves dias', 'Alê Itada', 'Porto Triste', '99999989', '100000.00'),
('Davi Agra', 'daviagra@outlook.com', '1234', '11111111120', '551140028929', 'rua sorvete bom', 'Alê Itada', 'Porto Triste', '99999979', '500.00');

insert into funcionario (nome, email, senha, cpf, telefone, rua, bairro, cidade, cep, salario)
values
('Marcus Vinicius', 'capitaoexercito@gmail.com', '1234', '11111111121', '551140028930', 'Av. Brasil', 'Crispin Tinho', 'Cabra Mansa', '99999777', '1500.00'),
('Matheus Correa', 'melhordev@gmail.com', '1234', '11111111122', '551140028931', 'Av. Sávio Lado', 'Paula Dentro', 'Cabra Mansa', '99999767', '10000.00'),
('Marcelo Betão', 'marcelaobeto@gmail.com', '1234', '11111111123', '551140028932', 'Rua Thiago Zado', 'Zona Boa', 'em modelagem', '99999661', '650.00'),
('Yasmin Betão', 'yasminbeto@gmail.com', '1234', '11111111124', '551140028933', 'Rua Thiago Zado', 'Zona Boa', 'em modelagem', '99999661', '0.00'),
('Valemtim Terra', 'val2151@outlook.com', '1234', '11111111125', '551140028934', 'Rua MySQL', 'Transição', 'feriados', '99999924','1000.00');

insert into pedido (valor, data, id_cliente)
values
('150.00', '2014-12-14 19:13:11', '1'),
('200.00', '2023-06-22 02:45:11', '2'),
('150.00', '2023-06-21 12:01:55', '3'),
('60.99', '2023-06-20 10:15:23', '4'),
('80.35', '2023-06-19 13:02:56', '5' ),
('70.55', '2023-06-18 11:01:01', '6'),
('45.50', '2023-06-17 11:02:02', '7'),
('52.20', '2023-06-16 01:30:15', '8'),
('22.00', '2023-06-15 15:19:25', '9'),
('60.99', '2023-06-14 05:50:22', '10'),
('80.35', '2023-06-13 04:45:15', '10');

insert into categoria (nome, id_funcionario)
values
('Limpeza', '1'),
('Brinquedo', '2'),
('Comida', '3'),
('eletrônicos', '4'),
('Pet', '5');

insert into produto (nome, preco, id_categoria, id_funcionario)
values
('Veja 5L', '22.00', '1', '1'),
('Fone Headset', '200.00', '4', '2'),
('Buzz Leighter', '150.00', '2', '3'),
('Coleira de ferro', '60.99', '5', '4'),
('Vinho', '80.35', '3', '5'),
('Barbie', '70.55', '2', '3'),
('Balde', '45.50', '1', '1'),
('Queijo 1kg', '52.20',  '3', '5');

insert into produto_pedido (quantidade, id_produto, id_pedido)
values 
('1','3','1'),
('1','2','2'),
('1','3','3'),
('1','4','4'),
('1','5','5'),
('1','6','6'),
('1','7','7'),
('1','8','8'),
('1','1','9'),
('1','4','10'),
('1','5','11');

___________________________________________________________________________________________________________________

/*Consultas*/


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
