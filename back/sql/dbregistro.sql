
create database dbregistro;
use dbregistro;
create table contatos(
idcon int primary  key auto_increment,
nome varchar(50),
idade varchar(50),
genero varchar(50),
telefone varchar(50),
email varchar(50),
cpf varchar(50)
);

show tables;

use dbregistro;
show tables;
describe contatos;

/* CREATE */
insert into contatos (idcon, nome, idade, genero, telefone, email, cpf) values (?,?,?,?,?,?,?);


/* READ */
select * from contatos;
select * from contatos order by idcon = nome;
select * from contatos where idcon = 1;

/* UPDATE */
update contatos set idade = '21' where idcon = 1;

/*Delete*/
delete from contatos where idcon = 3;

