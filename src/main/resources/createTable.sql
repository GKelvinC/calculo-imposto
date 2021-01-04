create table imposto (
	id int primary key auto_increment not null,
    nome_pessoa varchar(255),
    documento varchar(4),
    salario double,
    aliquota double,
    valor_imposto double
);

drop table imposto;

select * from imposto;

insert into imposto values (null,'Kelvin Gonçalves','CPF','1000','22.5','300')