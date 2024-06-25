-- data.sql
CREATE TABLE IF NOT EXISTS aplicativo (
    codigo INT PRIMARY KEY,
    nome VARCHAR(100),
    custo_mensal DECIMAL(10,2)
);

INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (1, 'Aplicativo 1', 99.99);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (2, 'Aplicativo 2', 49.99);


CREATE TABLE IF NOT EXISTS clientes (
    codigo INT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100)
);


INSERT INTO clientes (codigo, nome, email) VALUES  (1, 'Gustavo', 'gustavo@email.com');