CREATE TABLE Cliente (
                         codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(255),
                         email VARCHAR(255)
);

CREATE TABLE Aplicativo (
                            codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255),
                            custoMensal DOUBLE
);

CREATE TABLE Assinatura (
                            codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
                            aplicativo_id BIGINT,
                            cliente_id BIGINT,
                            inicioVigencia DATE,
                            fimVigencia DATE,
                            FOREIGN KEY (aplicativo_id) REFERENCES Aplicativo(codigo),
                            FOREIGN KEY (cliente_id) REFERENCES Cliente(codigo)
);

CREATE TABLE Pagamento (
                           codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
                           assinatura_id BIGINT,
                           valorPago DOUBLE,
                           dataPagamento DATE,
                           promocao VARCHAR(255),
                           FOREIGN KEY (assinatura_id) REFERENCES Assinatura(codigo)
);