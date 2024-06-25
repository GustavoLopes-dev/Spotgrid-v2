INSERT INTO Cliente (nome, email) VALUES ('Cliente1', 'cliente1@example.com');
INSERT INTO Cliente (nome, email) VALUES ('Cliente2', 'cliente2@example.com');

INSERT INTO Aplicativo (nome, custoMensal) VALUES ('App1', 9.99);
INSERT INTO Aplicativo (nome, custoMensal) VALUES ('App2', 19.99);

INSERT INTO Assinatura (aplicativo_id, cliente_id, inicioVigencia, fimVigencia) VALUES (1, 1, '2024-01-01', '2024-02-01');
INSERT INTO Assinatura (aplicativo_id, cliente_id, inicioVigencia, fimVigencia) VALUES (2, 2, '2024-01-01', '2024-02-01');

INSERT INTO Pagamento (assinatura_id, valorPago, dataPagamento, promocao) VALUES (1, 9.99, '2024-01-01', 'none');
INSERT INTO Pagamento (assinatura_id, valorPago, dataPagamento, promocao) VALUES (2, 19.99, '2024-01-01', 'none');