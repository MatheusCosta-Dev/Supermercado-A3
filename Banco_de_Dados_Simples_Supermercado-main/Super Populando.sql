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

insert into produto (nome, preco, id_categoria, id_funcionario, quantidade_estoque)
values
('Veja 5L', '22.00', '1', '1', '50'),
('Fone Headset', '200.00', '4', '2', '50'),
('Buzz Leighter', '150.00', '2', '3', '100'),
('Coleira de ferro', '60.99', '5', '4', '20'),
('Vinho', '80.35', '3', '5', 30),
('Barbie', '70.55', '2', '3', 40),
('Balde', '45.50', '1', '1', 50),
('Queijo 1kg', '52.20',  '3', '5', 100);

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