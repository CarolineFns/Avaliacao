--alter table pessoa drop CONSTRAINT fk_cargopessoa;
--alter table empresa drop CONSTRAINT fk_donoempresa;

--drop table empresa;
--drop table cargo;
--drop table pessoa;

create table empresa(
	id serial not null,
	iddono bigint,
	cnpj varchar(200),
	nome varchar(200),
	constraint pk_empresa primary key (id)
);

create table cargo(
	id serial not null,
	nome varchar(200),
	constraint pk_cargo primary key (id)
);

create table pessoa(
	id serial not null,
	idcargo bigint,
	nome varchar(200),
	cpf varchar(200),
	salario double precision,
	constraint pk_pessoa primary key (id)
);

alter table pessoa add constraint fk_cargopessoa foreign key (idcargo) references cargo(id);
alter table empresa add constraint fk_donoempresa foreign key (iddono) references pessoa(id);

insert into cargo (nome) values ('Estagiário');
insert into cargo (nome) values ('Diretor');
insert into cargo (nome) values ('Gerente');