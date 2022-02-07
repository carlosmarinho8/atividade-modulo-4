-- Create database
CREATE DATABASE ProjetoAgencia;
USE ProjetoAgencia;

-- Create table
CREATE TABLE registro(
id_registro int primary key auto_increment,
nome varchar(50),
idade int,
genero varchar(25),
telefone bigint,
email varchar(50),
cpf bigint
);
CREATE TABLE viagem
(
id_viagem int primary key auto_increment,
fk_registro int,
FOREIGN KEY(fk_registro) REFERENCES registro(id_registro),
destino varchar(50),
data_de_destino date,
hora time
);
INSERT INTO registro(nome, idade, genero, telefone, email, cpf) VALUES

('Arthur', 21, 'Masculino', 3333444, 'arthur@yahoo.com', 07061602074),
('Helena', 25, 'Feminino', 33335555, 'helena@gmail.com', 01493148095),
('Miguel', 30, 'Masculino', 33336666, 'miguel@outlook.com', 16979730002),
('Alice', 40, 'Feminino', 33337777, 'alice@yahoo.com', 80834557096),
('Davi', 60, 'Masculino', 33338888, 'davi@gmail.com',  66742662050),
('Amanda', 18, 'Feminino', 33339999, 'amanda@outlook.com', 56369253014),
('Theo', 50, 'Masculino', 44441111, 'theo@yahoo.com', 69163725088);

INSERT INTO viagem(fk_registro, destino, data_de_destino, hora) values
(7, 'Nova York, Estados Unidos', '2022-02-10', '18:00:00'),
(1, 'Paris, França', '2022-02-15', '13:00:00'),
(6, 'Tokyo, Japão', '2022-02-28', '15:30:00'),
(2, 'Florianópolis, Santa Catarina', '2022-02-07', '10:00:00'),
(5, 'Buenos Aires, Agentina', '2022-02-27', '20:00:00'),
(3, 'Cidade do Mexico, Mexico', '2022-02-27', '07:00:00'),
(4, 'Toronto, Canadá','2022-02-08', '12:00:00');

-- Read

select * from registro;
select * from viagem;

-- Update / A cliente Helena mudou de telefone e foi preciso atualizar seus dados

UPDATE registro
SET telefone = '44442222'
WHERE id_registro = 1;
SELECT * FROM registro;

-- Delete / O Cliente Davi decidiu cancelar sua viagem, então sua reserva teve que ser retirada
DELETE registro
WHERE fk_registro = 5;
SELECT * FROM viagem;

-- Stored procedure and inner join

DELIMITER $$
CREATE PROCEDURE GetRegistroViagem()
BEGIN
	SELECT nome, idade, genero, telefone, email, cpf, destino, data_de_destino, hora
	FROM registro
	INNER JOIN viagem
	ON registro.id_registro = viagem.fk_registro
    ORDER BY nome;
END$$
DELIMITER ;

CALL GetRegistroViagem();

-- inner join
SELECT nome, idade, genero, telefone, email, cpf, destino, data_de_destino, hora
FROM registro
INNER JOIN viagem
ON registro.id_registro = viagem.fk_registro
ORDER BY nome;
