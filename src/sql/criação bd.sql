create database postodegasolina;

use postodegasolina;

create table cliente(
    id int auto_increment not null,
    nome varchar(40) not null,
    cpf varchar(40) not null,
    sexo varchar(1) not null,
    telefone varchar(20),
    endereco varchar(40),
    datadenascimento date,
    
    primary key (id) 
);

create table deposito(
    id int auto_increment not null,
    nome varchar(40) not null unique,
    endereco varchar(40) not null,

    primary key (id)
);

create table produto(
    id int AUTO_INCREMENT not null,
    nome varchar(40) not null unique,
    precoatual double not null,
    quantidade int,
 	
    primary key (id)
);

create table depositoproduto(
    iddeposito int not null,
    idproduto int not null,
    
    foreign key (iddeposito) references deposito (id),
    foreign key (idproduto) references produto (id)

);

create table venda(
    id int AUTO_INCREMENT not null,
    pagamentoforma varchar(40) not null,
    subtotalsoma double not null,
    valortotal double not null,
    idcliente int not null,
    data date not null,
    dias int not null,
    
    primary key (id),
    foreign key (idcliente) references cliente (id)
);

create table vendaproduto(
    idvenda int not null,
    idproduto int not null,
    quantidade int not null,
    
    foreign key (idvenda) references venda (id),
    foreign key (idproduto) references produto (id)
);


