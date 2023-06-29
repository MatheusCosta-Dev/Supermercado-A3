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
