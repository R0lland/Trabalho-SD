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