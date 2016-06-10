/*Tabela CARRO - Pricipal*/
CREATE TABLE CARRO (

	CODIGO 		INTEGER CONSTRAINT PK_CODCARRO PRIMARY KEY NOT NULL,
	MARCA 		VARCHAR(200) NOT NULL,
	MODELO 		VARCHAR(200) NOT NULL,
	ANO 		INTEGER,
	POTENCIA 	NUMERIC(10,3) ,
	CARGA		NUMERIC(10,3) ,
	COMPLEMENTO VARCHAR(200)

);

/*
- codigo: Inteiro (chave primária)
- Marca: String
- Modelo: String
- Ano: Integer
- Potencia: Float
- Carga: Float
- Complemento: Varchar  */


/*Função responsável por criar um link entre o banco local e a nuvem*/
CREATE OR REPLACE FUNCTION f_desconecta()
  RETURNS void AS
$BODY$
BEGIN
PERFORM dblink_disconnect('conexao');
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


/*Função responsável por encerrar o link entre o banco local e a nuvem*/
CREATE OR REPLACE FUNCTION f_conecta()
  RETURNS void AS
$BODY$
BEGIN
PERFORM dblink_connect('conexao','host=pellefant-02.db.elephantsql.com port=5432 user=gxtxqoyk password=Zr7RR6weUL6LNrGhPvmu9K0fKEiVM526 dbname=gxtxqoyk');
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


/*Função responsável por adicionar na nuvem */
CREATE OR REPLACE FUNCTION f_Replica()
RETURNS TRIGGER as $tr$
DECLARE 
BEGIN
PERFORM dblink_exec('conexao','INSERT INTO Carro (codigo, marca, modelo, ano, potencia, carga, complemento) 
			VALUES ('||CHR(39)||new.codigo||CHR(39)||', '||CHR(39)||new.marca||CHR(39)||', '||CHR(39)||new.modelo||CHR(39)||', '||CHR(39)||new.ano||CHR(39)||', '||CHR(39)||new.potencia||CHR(39)||', '||CHR(39)||new.carga||CHR(39)||', '||CHR(39)||new.complemento||CHR(39)||')');
RETURN new;
END;
$tr$ Language 'plpgsql';


/*Trigger responsável por chamar a função a cada inserção da tabela carro*/
create trigger t_Replica AFTER insert
on Carro for each row
execute procedure f_Replica();


/*Função responsável por alterar na nuvem*/
CREATE OR REPLACE FUNCTION f_Replica_update()
RETURNS TRIGGER as $tr$
DECLARE 
BEGIN
PERFORM dblink_exec('conexao','UPDATE carro SET marca = ' ||CHR(39) || new.marca ||CHR(39) || ', modelo = ' ||CHR(39) ||new.modelo ||CHR(39) || ', ano = ' || new.ano || ', potencia = ' || new.potencia || ', carga = ' || new.carga|| ', complemento = ' ||CHR(39) ||new.complemento ||CHR(39) ||' WHERE codigo = ' ||new.codigo); 
			RETURN new;
END;
$tr$ Language 'plpgsql';


/*Trigger responsável por chamar a função a cada alteração da tabela carro*/
create trigger t_Replica_update AFTER update
on Carro for each row
execute procedure f_Replica_update();


/*Função responsável por deletar na nuvem*/
CREATE OR REPLACE FUNCTION f_Replica_delete()
RETURNS TRIGGER as $tr$
DECLARE 
BEGIN
PERFORM dblink_exec('conexao','DELETE FROM carro WHERE codigo = ' ||old.codigo); 
			RETURN old;
END;
$tr$ Language 'plpgsql';


/*Trigger responsável por chamar a função a cada delete na tabela carro*/
create trigger t_Replica_delete AFTER delete
on Carro for each row
execute procedure f_Replica_delete();


/*
drop function f_Replica();

drop trigger t_Replica on carro;

*/
