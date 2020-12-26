BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (product_id BIGSERIAL PRIMARY KEY, title VARCHAR (255), price INT);
INSERT INTO products (title, price) VALUES
('Авокадо', 70),
('Хлеб', 1),
('Рыба', 50),
('Яблоко', 15),
('Макароны', 10),
('Мясо', 90),
('Пирожок с вишней', 10),
('Торт', 30),
('Лимон', 5),
('Варенье', 15);

DROP TABLE IF EXISTS clients CASCADE;
CREATE TABLE clients (client_id BIGSERIAL PRIMARY KEY, client_name VARCHAR (255));
INSERT INTO clients (client_name) VALUES
('Петр'),
('Иван'),
('Сергей');

DROP TABLE IF EXISTS clients_products CASCADE;
CREATE TABLE clients_products (client_id bigint, product_id bigint, FOREIGN KEY (client_id) REFERENCES clients (client_id), FOREIGN KEY (product_id) REFERENCES products (product_id));
INSERT INTO clients_products (client_id, product_id) VALUES
(1, 4),
(1, 7),
(1, 8),
(2, 1),
(2, 4),
(2, 9),
(2, 10),
(3, 2),
(3, 3),
(3, 5),
(3, 6),
(3, 9);

COMMIT;