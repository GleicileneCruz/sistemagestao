INSERT INTO tb_user (nome, sobrenome, email, senha) VALUES ('Admin', 'Admin', 'admin@gmail.com', '123456');
INSERT INTO tb_user (nome, sobrenome, email, senha) VALUES ('Neia', 'Santos', 'neia@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (nome, sobrenome, email, senha) VALUES ('Cilene', 'Cruz', 'cilene@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (nome, sobrenome, email, senha) VALUES ('Ana Maria', 'Souza', 'anam@gmail.com', '123456');
INSERT INTO tb_user (nome, sobrenome, email, senha) VALUES ('João Carlos', 'Lumbier', 'joao@gmail.com', '123456');

INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Batom', 1, NOW(), 'Batom vermelho', 2);
INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Colar', 7, NOW(), 'Colar Dourado', 3);
INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Shampoo', 5, NOW(), 'Especifico para cabelos cacheados', 10);
INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Base', 3, NOW(), 'Cor 3004 média', 6);
INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Pulseira', 2, NOW(), 'Pulseira folheada no prata', 12);
INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Brinco', 6, NOW(), 'Brinco em argola', 4);
INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Cilios', 13, NOW(), 'Kit com 3 pares', 10);
INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Condicionador', 15, NOW(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit...', 20);
INSERT INTO tb_product (name, price, date, description, quantity) VALUES ('Creme de pentear', 10, NOW(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit...', 3);

INSERT INTO tb_category(name, created_At) VALUES ('Maquiagens', NOW());
INSERT INTO tb_category(name, created_At) VALUES ('Acessorios', NOW());
INSERT INTO tb_category(name, created_At) VALUES ('Roupa', NOW());
INSERT INTO tb_category(name, created_At) VALUES ('Cosmeticos', NOW());

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 2);

