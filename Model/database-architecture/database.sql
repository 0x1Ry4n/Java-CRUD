#System for a pizza restaurant, managing orders, employees, products, ingredients, customers and tables. #

CREATE DATABASE bd_pizzaria;

USE bd_pizzaria;

CREATE TABLE tb_cliente ( #clients
	id_Cliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT, #client id
	nomeCliente VARCHAR(250) NOT NULL, #name of the client 
	cpf_Cli CHAR(14) UNIQUE, #confidential data 
	telefone CHAR(14), #phone number	
	bairro VARCHAR(250) NOT NULL, #district
	complemento VARCHAR(250) NOT NULL, #complement
	numeroCasa INT NOT NULL	#number of the home
);


CREATE TABLE tb_mesa ( #table on the pizza restaurant
	id_Mesa INT NOT NULL PRIMARY KEY AUTO_INCREMENT, #table id
	nomeCliente VARCHAR(255) NOT NULL, #name of the client on table
	numMesa INT NOT NULL #table number 
);


CREATE TABLE tb_produto ( #products
	id_Cardapio INT NOT NULL PRIMARY KEY AUTO_INCREMENT, #product id
	nomePizza VARCHAR(200) NOT NULL, #pizza name
	descricao VARCHAR(250) NOT NULL, #description
	tam_Pizza VARCHAR(10) NOT NULL, #size of the pizza
	bebida VARCHAR(250), #drinks option
	preco FLOAT NOT NULL, #price
	adicional VARCHAR(255) #additional
);



CREATE TABLE tb_funcionario ( #employees
	id_Funcionario INT NOT NULL PRIMARY KEY AUTO_INCREMENT, #employess id
	nome VARCHAR(200) NOT NULL, #name 
	cargo VARCHAR(200) NOT NULL, #office
	RG CHAR(12) NOT NULL, #confidential data
	salario FLOAT NOT NULL #remuneration
);



CREATE TABLE tb_pedido ( #orders
	id_Pedido INT NOT NULL PRIMARY KEY AUTO_INCREMENT, #order id
	data_Ped CHAR(11) NOT NULL, #date of the order
	cod_Cliente INT NOT NULL, #code of the client
	cod_Produto INT NOT NULL, #code of the product
	cod_Funcionario INT NOT NULL, #code of the employee
	cod_Mesa INT NOT NULL, #code of the pizza restaurant table
	#------foreign keys------#
	FOREIGN KEY(cod_Cliente) REFERENCES tb_cliente(id_Cliente), 
	FOREIGN KEY(cod_Produto) REFERENCES tb_produto(id_Cardapio),
	FOREIGN KEY(cod_Mesa) REFERENCES tb_mesa(id_Mesa),
	FOREIGN KEY(cod_Funcionario) REFERENCES tb_funcionario(id_Funcionario)
);

CREATE TABLE tb_usuario( #control the user acess
	id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY, #user id
	nome_usuario VARCHAR(45) NOT NULL, #username
	senha_usuario VARCHAR(45) NOT NULL #password
);



			
